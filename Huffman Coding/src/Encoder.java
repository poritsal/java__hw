import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Encoder {
  private final int BUFFERSIZE = 1024;

  public void encode(String input, String output) throws IOException {
    FileInputStream fileIn = new FileInputStream(input);
    FileOutputStream fileOut = new FileOutputStream(output + ".bin");

    HashMap<Byte, Integer> counter = readStatistic(fileIn);
    HuffmanTree tree = new HuffmanTree(counter);
    HuffmanHeader head = new HuffmanHeader();
    head.extension = this.getExtension(input);
    head.table = tree.getTable();
    head.calculateTablePtr();
    head.calculateDataPtr();
    head.calculateDataSize(counter);
    head.write(fileOut);

    fileIn.close();
    fileIn = new FileInputStream(input);
    this.writeData(fileIn, fileOut, head.table);

    fileIn.close();
    fileOut.close();
  }

  private HashMap<Byte, Integer> readStatistic(FileInputStream fis) throws IOException {
    HashMap<Byte, Integer> map = new HashMap<>();
    byte[] buffer = new byte[BUFFERSIZE];
    int count;

    while ((count = fis.read(buffer)) != -1) {
      for (int i = 0; i < count; i++) {
        if (map.containsKey(buffer[i]))
          map.replace(buffer[i], map.get(buffer[i]) + 1);
        else
          map.put(buffer[i], 1);
      }
    }

    return map;
  }

  private String getExtension(String fileName) {
    int i = fileName.lastIndexOf('.');
    return (i > 0) ? fileName.substring(i) : "";
  }

  private void writeData(FileInputStream fis, FileOutputStream fos, HashMap<Byte, String> table) throws IOException {
    byte[] buffer = new byte[BUFFERSIZE];
    int count;

    String data = "";
    while ((count = fis.read(buffer)) != -1) {
      for (int i = 0; i < count; i++)
        data += table.get(buffer[i]);

      int size = data.length() - (data.length() % 8);
      String tmp = data.substring(size);
      this.writeBits(fos, data, size);
      data = tmp;
    }

    if (data.length() != 0)
      this.writeBits(fos, data, 8);
  }

  private void writeBits(FileOutputStream fos, String data, int size) throws IOException {
    byte[] bits = new byte[size / 8];

    for (int i = 0; i < 8 * bits.length; i += 8) {
      byte tmp = 0;
      for (int j = 0; j < 8; j++)
        tmp = (byte) ((tmp << 1) |
            ((i + j < data.length()) ? data.charAt(i + j) - '0' : 0));
      bits[i / 8] = tmp;
    }

    fos.write(bits);
  }
}
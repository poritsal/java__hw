import java.io.*;
import java.util.PriorityQueue;
import java.util.HashMap;

public class HuffmanCoding {

    // Хранение кодов Хаффмана для каждого символа
    private HashMap<Character, String> huffmanCodes = new HashMap<>();

    // Метод для кодирования данных и записи результата в файл
    public void encode(String inputFileName, String outputFileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFileName);
            int[] frequencies = new int[256];

            // Подсчет частот символов
            int data;
            while ((data = fileInputStream.read()) != -1) {
                frequencies[data]++;
            }

            // Построение дерева Хаффмана
            PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
            for (int i = 0; i < frequencies.length; i++) {
                if (frequencies[i] > 0) {
                    priorityQueue.add(new HuffmanNode((char) i, frequencies[i], null, null));
                }
            }

            while (priorityQueue.size() > 1) {
                HuffmanNode left = priorityQueue.poll();
                HuffmanNode right = priorityQueue.poll();
                HuffmanNode parent = new HuffmanNode('\0', left.data + right.data, left, right);
                priorityQueue.add(parent);
            }

            HuffmanNode root = priorityQueue.poll();

            // Создание кодов Хаффмана
            generateCodes(root, "");

            FileWriter fileWriter = new FileWriter(outputFileName);

            // Запись дерева Хаффмана
            fileWriter.write("Huffman Tree:\n");
            writeCodesToFile(root, "", fileWriter);
            fileWriter.write("\n");

            // Запись закодированных данных
            fileInputStream.close();
            fileInputStream = new FileInputStream(inputFileName);
            writeEncodedData(fileInputStream, fileWriter);

            fileInputStream.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для декодирования данных и записи результата в файл
    public void decode(String inputFileName, String outputFileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
            FileWriter fileWriter = new FileWriter(outputFileName);
    
            // Пропуск первой строки
            bufferedReader.readLine();
    
            // Построение дерева Хаффмана из файла
            HuffmanNode root = buildHuffmanTree(bufferedReader);
    
            // Декодирование данных и запись в выходной файл
            decodeData(bufferedReader, fileWriter, root);
    
            bufferedReader.close();
            fileWriter.close();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Метод для построения дерева Хаффмана из файла
    private HuffmanNode buildHuffmanTree(BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split(": ");
            char c = parts[0].charAt(0);
            String code = parts[1];
            huffmanCodes.put(c, code);
        }
    
        // Восстановление дерева Хаффмана из сгенерированных кодов
        HuffmanNode root = reconstructHuffmanTree();
    
        return root;
    }
    
    // Метод для восстановления дерева Хаффмана
    private HuffmanNode reconstructHuffmanTree() {
        HuffmanNode root = new HuffmanNode('\0', 0, null, null);
    
        for (char c : huffmanCodes.keySet()) {
            String code = huffmanCodes.get(c);
            HuffmanNode current = root;
    
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == '0') {
                    if (current.left == null) {
                        current.left = new HuffmanNode('\0', 0, null, null);
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = new HuffmanNode('\0', 0, null, null);
                    }
                    current = current.right;
                }
            }
    
            current.c = c;
        }
    
        return root;
    }

    // Метод для генерации кодов Хаффмана
    private void generateCodes(HuffmanNode root, String code) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.c, code);
        }

        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    // Метод для записи кодов Хаффмана в файл
    private void writeCodesToFile(HuffmanNode root, String code, FileWriter fileWriter) throws IOException {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            fileWriter.write(root.c + ": " + code + "\n");
        }

        writeCodesToFile(root.left, code + "0", fileWriter);
        writeCodesToFile(root.right, code + "1", fileWriter);
    }

    // Метод для записи закодированных данных в файл
    private void writeEncodedData(FileInputStream inputStream, FileWriter fileWriter) throws IOException {
        int data;
        StringBuilder stringBuilder = new StringBuilder();

        while ((data = inputStream.read()) != -1) {
            String code = huffmanCodes.get((char) data);
            stringBuilder.append(code);
        }

        fileWriter.write(stringBuilder.toString());
    }

    // Метод для декодирования данных
    private void decodeData(BufferedReader bufferedReader, FileWriter fileWriter, HuffmanNode root) throws IOException {
        HuffmanNode current = root;
    
        int bit;
        while ((bit = bufferedReader.read()) != -1) {
            char c = (char) bit;
            if (c == '0') {
                current = current.left;
            } else if (c == '1') {
                current = current.right;
            }
    
            if (current.left == null && current.right == null) {
                fileWriter.write(current.c);
                current = root;
            }
        }
    }

    // Метод для чтения последней строки из файла
    private String readLastLineFromFile(String fileName) throws IOException {
        String lastLine = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lastLine = line;
            }
        }
        return lastLine;
    }
    
    // Метод для вывода информации о сжатии данных
    public void info(String encodedFileName) {
        try {
            String decodedFileName = "decoded_temp.txt"; 
            decode(encodedFileName, decodedFileName);
    
            String decodedString = readStringFromFile(decodedFileName);
    
            BufferedReader bufferedReader = new BufferedReader(new FileReader(encodedFileName));                        
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                System.out.println(line);
            }
    
            String encodedData = readLastLineFromFile(encodedFileName);
    
            int originalSize = decodedString.getBytes().length * 8; 
            int compressedSize = encodedData.length();
            double compressionRatio = (double) originalSize / compressedSize;
    
            System.out.println("Compression Ratio: " + compressionRatio);
            System.out.println("Original Size: " + originalSize + " bits");
            System.out.println("Compressed Size: " + compressedSize + " bits");
    
            File tempFile = new File(decodedFileName);
            if (tempFile.exists()) {
                tempFile.delete();
            }
    
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Метод для чтения строки из файла
    private String readStringFromFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }    
}

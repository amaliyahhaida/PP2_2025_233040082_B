/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul09;

/**
 *
 * @author Amaliyah
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {

    // Komponen utama aplikasi
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary;
    // Latihan 3: tombol serialisasi objek
    private JButton btnSaveObj, btnLoadObj;
    // Latihan 4: tombol tambah isi file
    private JButton btnAppendText;
    
    private JFileChooser fileChooser;

    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(800, 500); // Saya perlebar sedikit agar tombol muat
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi Komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 4, 5, 5)); 

        // Tombol fitur file teks & binary
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        btnSaveBinary = new JButton("Simpan Config (Bin)");
        btnLoadBinary = new JButton("Muat Config (Bin)");

        // Latihan 3 (Inisialisasi Tombol)
        btnSaveObj = new JButton("Simpan Objek");
        btnLoadObj = new JButton("Muat Objek");

        // Latihan 4 (Inisialisasi Tombol) 
        btnAppendText = new JButton("Tambah Text (Append)");

        // Menambahkan tombol ke panel
        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);
        // Menambahkan tombol Latihan 3 & 4 ke panel
        buttonPanel.add(btnSaveObj);
        buttonPanel.add(btnLoadObj);
        buttonPanel.add(btnAppendText);

        // Menyusun layout
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Event Handling ---

        // 1. MEMBACA FILE TEKS (Text Stream)
        btnOpenText.addActionListener(e -> bukaFileTeks());

        // 2. MENULIS FILE TEKS (Text Stream)
        btnSaveText.addActionListener(e -> simpanFileTeks());

        // 3. MENULIS FILE BINARY (Byte Stream)
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());

        // 4. MEMBACA FILE BINARY (Byte Stream)
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        
        // Latihan 3 (Event Handling) 
        btnSaveObj.addActionListener(e -> simpanFileObjek());
        btnLoadObj.addActionListener(e -> muatFileObjek());
        
        // Latihan 4 (Event Handling) 
        btnAppendText.addActionListener(e -> tambahFileTeks());
       
        // Latihan 2: Baca file otomatis saat dibuka
        bacaLastNotes();
    } 
    
    // Latihan 2: membaca file last_notes.txt
    private void bacaLastNotes() {
        File file = new File("C:\\Users\\astri\\OneDrive\\Documents\\NetBeansProjects\\PraktikumPemograman2\\src\\main\\java\\id\\ac\\unpas\\praktikumpemograman2\\Modul9\\last_notes.txt");

        // Jika file tidak ada, langsung keluar
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            textArea.setText("");
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (FileNotFoundException ex) {
            // File tidak ditemukan, diam saja (sesuai modul)
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca last_notes.txt: " + ex.getMessage());
        }
    }

    // 1. Contoh: Membaca File Teks dengan Try-Catch-Finally Konvensional
    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null; 

            try {
                reader = new BufferedReader(new FileReader(file));
                textArea.setText(""); 

                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            } finally {
                try {
                    if (reader != null) {
                        reader.close(); 
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // 2. Contoh: Menulis File Teks menggunakan Try-With-Resources
    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage());
            }
        }
    }

    // 3. Contoh: Menulis Binary (Menyimpan integer)
    private void simpanConfigBinary() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("config.bin"))) {
            int fontSize = textArea.getFont().getSize();
            dos.writeInt(fontSize);
            JOptionPane.showMessageDialog(this, "Ukuran font (" + fontSize + ") disimpan ke config.bin");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan binary: " + ex.getMessage());
        }
    }

    // 4. Contoh: Membaca Binary (Membaca integer)
    private void muatConfigBinary() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("config.bin"))) {
            int fontSize = dis.readInt();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
            JOptionPane.showMessageDialog(this, "Font diubah menjadi ukuran: " + fontSize);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File config.bin belum dibuat!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca binary: " + ex.getMessage());
        }
    }
    
    // Latihan 3: Menyimpan & Membaca Objek (Serialization)/baca objek UserConfig
    private void simpanFileObjek() {
        UserConfig config = new UserConfig();
   
        String user = JOptionPane.showInputDialog(this, "Masukkan Username:");
        if (user == null || user.isEmpty()) return; // Batal jika kosong

        config.setUsername(user);
        config.setFontSize(textArea.getFont().getSize()); 

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.cfg"))) {
            oos.writeObject(config); // Write object
            JOptionPane.showMessageDialog(this, "Objek berhasil disimpan! (User: " + user + ")");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan objek: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void muatFileObjek() {
        // Membaca Objek menggunakan ObjectInputStream
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.cfg"))) {
            UserConfig config = (UserConfig) ois.readObject();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontSize()));
            
            JOptionPane.showMessageDialog(this, 
                "Objek dimuat!\nUsername: " + config.getUsername() + 
                "\nFont Size: " + config.getFontSize());
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File user.cfg belum pernah dibuat.");
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca objek: " + ex.getMessage());
        }
    }

    //Latihan 4: Append Text menambah teks tanpa menghapus isi lama
    private void tambahFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Parameter 'true' pada FileWriter(file, true) menandakan mode APPEND
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                
                writer.newLine(); // Tambah baris baru dulu agar rapi
                writer.write(textArea.getText()); // Tulis teks dari area
                
                JOptionPane.showMessageDialog(this, "Teks berhasil ditambahkan ke file!");
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan teks: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }
}
import javax.swing.*;
import java.awt.*;

public class LibraryManagement {

    JFrame frame;
    JTextField bookField;
    JTextField authorField;
    JTextArea displayArea;

    public LibraryManagement() {

        frame = new JFrame("Library Management System");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel bookLabel = new JLabel("Book:");
        bookField = new JTextField(15);

        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField(15);

        JButton addButton = new JButton("Add Book");
        JButton clearButton = new JButton("Clear");

        displayArea = new JTextArea(15,40);
        displayArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(displayArea);

        addButton.addActionListener(e -> addBook());

        clearButton.addActionListener(e -> {
            displayArea.setText("");
            bookField.setText("");
            authorField.setText("");
        });

        frame.add(bookLabel);
        frame.add(bookField);

        frame.add(authorLabel);
        frame.add(authorField);

        frame.add(addButton);
        frame.add(clearButton);

        frame.add(scroll);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addBook() {

        String book = bookField.getText();
        String author = authorField.getText();

        if(book.isEmpty() || author.isEmpty()) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Fill all fields!"
            );

            return;
        }

        displayArea.append(
                "Book: " + book +
                " | Author: " + author +
                "\n"
        );

        bookField.setText("");
        authorField.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new LibraryManagement()
        );
    }
}
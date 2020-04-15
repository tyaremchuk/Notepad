package ntpd_pckg1;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notepad implements ActionListener
{
    JFrame f;
    JTextArea ta;
    static JLabel l;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, helpMenu;
    JMenuItem newFileItem, openFileItem, saveFileItem, cutItem, copyItem, pasteItem, selectAllItem, aboutItem;

    Notepad()
    {
        f = new JFrame("Notepad");
        ta = new JTextArea();
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");
        newFileItem = new JMenuItem("New");
        openFileItem = new JMenuItem("Open");
        saveFileItem = new JMenuItem("Save");
        cutItem  = new JMenuItem("Cut");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");
        selectAllItem = new JMenuItem("Select All");
        aboutItem = new JMenuItem("About");
        openFileItem.addActionListener(this);
        newFileItem.addActionListener(this);
        cutItem.addActionListener(this);
        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);
        selectAllItem.addActionListener(this);
        fileMenu.add(newFileItem); fileMenu.add(openFileItem); fileMenu.add(saveFileItem);
        editMenu.add(cutItem); editMenu.add(copyItem); editMenu.add(pasteItem); editMenu.add(selectAllItem);
        helpMenu.add(aboutItem);
        menuBar.add(fileMenu); menuBar.add(editMenu); menuBar.add(helpMenu);
        f.add(menuBar);
        f.add(ta);

        f.setLocation(100,50);
        f.setJMenuBar(menuBar);
        f.setSize(600,600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==cutItem)
            ta.cut();
        else if (e.getSource()==copyItem)
            ta.copy();
        else if (e.getSource()==pasteItem)
            ta.paste();
        else if (e.getSource()==selectAllItem)
            ta.selectAll();
        else if (e.getSource()==openFileItem)
        {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int r = fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String filePath = file.getPath();
            try {
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String str1="",str2="";
                while ((str1=br.readLine())!=null)
                {
                    str2+=str1+"\n";
                }
                ta.setText(str2);
            }
            catch (Exception exception) {exception.printStackTrace();}
        }
        else if (e.getSource()==saveFileItem)
        {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int r = fileChooser.showSaveDialog(null);
            if (r==JFileChooser.APPROVE_OPTION)
            {
                File fileToSave = fileChooser.getSelectedFile();
                try
                {
                    boolean isFile = false;
                    if (!fileToSave.exists())
                        isFile=fileToSave.createNewFile();
                    FileWriter outFile = new FileWriter(fileToSave);
                }
                catch (IOException exception){
                    System.out.println(exception);
                }
            }
        }
    }
    public static void main(String[] args)
    {
        new Notepad();
    }
}

package ntpd_pckg1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notepad implements ActionListener
{
    JFrame f;
    JTextArea ta;
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
    }
    public static void main(String[] args)
    {
        new Notepad();
    }
}

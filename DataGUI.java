import javax.swing.*;
import java.awt.*;


public class DataGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    private FileOperator file = new FileOperator("data/arenas.txt");
    
    public DataGUI() {
        setTitle("Arena Data Analyzer");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        JButton analyzeTeamButton = new JButton("Analyze by Team");
        JButton commonLocationButton = new JButton("Get Most Common Arena Location");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);

        add(inputField);
        add(analyzeTeamButton);
        add(commonLocationButton);
        add(new JScrollPane(resultsArea));

        analyzeTeamButton.addActionListener(e -> analyzeByTeam());
        commonLocationButton.addActionListener(e -> getMostCommonArena());
    }

    private static String stringify(String[] arr) {
        String result = "";
        for(String s : arr) {
            result += s + "\n";
        }
        return result;
    }
    private static String stringify_int(int[] arr) {
        String result = "";
        for(int s : arr) {
            result += s + "\n";
        }
        return result;
    }

    private void analyzeByTeam(){
        String[] arenas = DataAnalyzer.arenasByTeam((inputField.getText()),file);

        resultsArea.setText("Arenas by Team " + inputField.getText() + ": \n" + stringify(arenas) + "\n");
    }


    private void getMostCommonArena(){
        String location = DataAnalyzer.findMostCommonArena(file);
        resultsArea.setText("Most Common Arena: " + location);
    }

    public void saveScreen(){
        try {
            
        } catch (Exception e) {
        }
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}
    
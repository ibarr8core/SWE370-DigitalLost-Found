package edu.csusm.digitalfound;

import javax.swing.*;
import java.awt.*;
import controller.ReportController;
import controller.SearchController;
import controller.ManageClaimsController;

public class Main {

    private static final Color COUGAR_BLUE = new Color(0, 94, 184);
    private static final Color LIGHT_BLUE = new Color(58, 182, 232);
    private static final Color MIST_GRAY = new Color(0xF5F7FA);
    private static final Color TEXT_DARK = new Color(0x003050);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createMainMenu);
    }

    private static void createMainMenu() {
        JFrame frame = new JFrame("Lost and Found System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 650);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        // ===== TOP BLUE BAR =====
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(COUGAR_BLUE);
        topBar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel menuIcon = new JLabel("\u2261");
        menuIcon.setForeground(Color.WHITE);
        menuIcon.setFont(new Font("SansSerif", Font.BOLD, 26));
        topBar.add(menuIcon, BorderLayout.WEST);

        JLabel title = new JLabel("CSUSM LOST AND FOUND", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        topBar.add(title, BorderLayout.CENTER);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        userPanel.setOpaque(false);
        JLabel userName = new JLabel("John Doe");
        userName.setForeground(Color.WHITE);
        userName.setFont(new Font("SansSerif", Font.PLAIN, 16));
        JLabel avatar = new JLabel("\u25CF");
        avatar.setForeground(Color.WHITE);
        avatar.setFont(new Font("SansSerif", Font.PLAIN, 26));
        userPanel.add(userName);
        userPanel.add(avatar);
        topBar.add(userPanel, BorderLayout.EAST);

        frame.add(topBar, BorderLayout.NORTH);

        // ===== CENTER CONTENT =====
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Color.WHITE);
        content.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        frame.add(content, BorderLayout.CENTER);

        JLabel mainMenuLabel = new JLabel("Main Menu");
        mainMenuLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        mainMenuLabel.setForeground(TEXT_DARK);
        mainMenuLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(mainMenuLabel);
        content.add(Box.createVerticalStrut(15));

        // ===== MAIN BUTTON ROW =====
        JPanel bigButtonsRow = new JPanel(new GridLayout(1, 3, 20, 0));
        bigButtonsRow.setBackground(Color.WHITE);

        JButton reportButton = new JButton("Report Lost Item");
        JButton searchButton = new JButton("Search Item");
        JButton manageClaimsButton = new JButton("Manage Claims");

        styleMainButton(reportButton, true);
        styleMainButton(searchButton, false);
        styleMainButton(manageClaimsButton, false);

        bigButtonsRow.add(reportButton);
        bigButtonsRow.add(searchButton);
        bigButtonsRow.add(manageClaimsButton);

        content.add(bigButtonsRow);
        content.add(Box.createVerticalStrut(25));

        // ===== QUICK CATEGORIES (EMPTY GRAY BOXES) =====
        JLabel quickLabel = new JLabel("Quick Categories");
        quickLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        quickLabel.setForeground(TEXT_DARK);
        quickLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(quickLabel);
        content.add(Box.createVerticalStrut(10));

        JPanel quickPanel = new JPanel(new GridLayout(1, 5, 20, 0));
        quickPanel.setBackground(Color.WHITE);
        quickPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add 5 empty gray squares
        for (int i = 0; i < 5; i++) {
            JPanel box = new JPanel();
            box.setBackground(MIST_GRAY);
            box.setPreferredSize(new Dimension(100, 100));
            quickPanel.add(box);
        }

        content.add(quickPanel);

        // ===== BUTTON ACTIONS =====
        reportButton.addActionListener(e -> openReportWindow());
        searchButton.addActionListener(e -> openSearchWindow());
        manageClaimsButton.addActionListener(e -> openManageClaimsWindow());

        frame.setVisible(true);
    }

    private static void styleMainButton(JButton button, boolean primary) {
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 18));
        button.setForeground(primary ? Color.WHITE : COUGAR_BLUE);
        button.setBackground(primary ? COUGAR_BLUE : Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(COUGAR_BLUE, 2, true));
        button.setPreferredSize(new Dimension(260, 120));
    }

    // ===== OPEN WINDOWS =====
    private static void openReportWindow() {
        JFrame reportFrame = new JFrame("Report Lost Item");
        reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportFrame.setSize(400, 250);
        reportFrame.add(new ReportController());
        reportFrame.setLocationRelativeTo(null);
        reportFrame.setVisible(true);
    }

    private static void openSearchWindow() {
        JFrame searchFrame = new JFrame("Search Lost Items");
        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchFrame.setSize(500, 300);
        searchFrame.add(new SearchController());
        searchFrame.setLocationRelativeTo(null);
        searchFrame.setVisible(true);
    }

    private static void openManageClaimsWindow() {
        JFrame claimsFrame = new JFrame("Manage Claims");
        claimsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        claimsFrame.setSize(600, 350);
        claimsFrame.add(new ManageClaimsController());
        claimsFrame.setLocationRelativeTo(null);
        claimsFrame.setVisible(true);
    }
}

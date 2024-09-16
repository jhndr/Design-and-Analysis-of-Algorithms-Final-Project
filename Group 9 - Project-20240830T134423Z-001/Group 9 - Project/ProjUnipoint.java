
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjUnipoint {

    JFrame frame;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;
    JLabel img1;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, imageLabel;
    JButton btnGuideIcon, btnSearchIcon, btnSearch, btnReset;
    JTextField field1, field2, field3, field4;
    JTextArea area1, area2, area3, area4, area5, area6;
    JRadioButton rad1, rad2, rad3, rad4, rad5, rad6, rad7;
    ButtonGroup radioGroup;
    Timer timer;
    List<ImageIcon> images;
    List<String> imageLabels;
    List<String> facilityNames;
    List<String> descriptions;
    List<String> routes;
    List<ImageIcon> mapImages;
    int currentImageIndex;
    String searchingText = "Searching...";
    String searchingMapsText = "Searching Corresponding Maps";
    HashMap<String, String> locationCategoryMap;

    public ProjUnipoint() {
        frame = new JFrame("UniPoint");
        frame.setSize(1400, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // labels
        ImageIcon Test = new ImageIcon("ColoredMap.jpg"); // CHANGE
        label1 = new JLabel(Test);
        label1.setBackground(new Color(114, 2, 2, 255));
        label1.setBounds(15, 90, Test.getIconWidth(), Test.getIconHeight());
        label1.setBorder(BorderFactory.createLineBorder(new Color(241, 99, 99, 255)));

        label2 = new JLabel("Location");
        label2.setBounds(0, 0, 100, 20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Arial", Font.BOLD, 15));

        label3 = new JLabel("Main Campus Map");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Arial", Font.BOLD, 16));
        label3.setBounds(180, 45, 200, 50);

        label4 = new JLabel("Locate");
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Arial", Font.BOLD, 15));
        label4.setBounds(40, 275, 100, 190);

        label5 = new JLabel("UniPoint");
        label5.setForeground(new Color(150, 18, 18, 255));
        label5.setFont(new Font("Arial", Font.BOLD, 35));
        label5.setBounds(70, 12, 150, 50);

        label6 = new JLabel("Navigating PUP Main Campus");
        label6.setForeground(new Color(150, 18, 18, 255));
        label6.setFont(new Font("Arial", Font.BOLD, 13));
        label6.setBounds(70, 55, 185, 12);

        label7 = new JLabel("Please enter a location.");
        label7.setForeground(new Color(247, 144, 144, 255));
        label7.setFont(new Font("Arial", Font.BOLD, 12));
        label7.setBounds(40, 450, 300, 12);

        ImageIcon Logo = new ImageIcon("PUPLogo.png");
        label8 = new JLabel(Logo);
        label8.setBounds(0, 0, 360, 60);
        label8.setText("Polytechnic University of the Philippines");
        label8.setForeground(new Color(150, 18, 18, 255));
        label8.setFont(new Font("Arial", Font.BOLD, 15));

        label9 = new JLabel("Description");
        label9.setBounds(60, 415, 100, 30);
        label9.setForeground(new Color(150, 18, 18, 255));
        label9.setFont(new Font("Arial", Font.BOLD, 17));

        label10 = new JLabel("Route");
        label10.setBounds(60, 505, 100, 30);
        label10.setForeground(new Color(150, 18, 18, 255));
        label10.setFont(new Font("Arial", Font.BOLD, 17));

        ImageIcon Unipoint = new ImageIcon("UnipointLogo.png");
        label11 = new JLabel(Unipoint);
        label11.setBackground(new Color(114, 2, 2, 255));
        label11.setBounds(28, 25, Unipoint.getIconWidth(), Unipoint.getIconHeight());

        label12 = new JLabel("List of Facilities");
        label12.setBounds(15, 20, 200, 30);
        label12.setForeground(Color.WHITE);
        label12.setFont(new Font("Arial", Font.BOLD, 19));

        // Radio Buttons
        rad1 = new JRadioButton();
        rad1.setEnabled(false);
        rad1.setOpaque(false);
        rad1.setHorizontalAlignment(JRadioButton.CENTER);
        rad2 = new JRadioButton();
        rad2.setEnabled(false);
        rad2.setOpaque(false);
        rad2.setHorizontalAlignment(JRadioButton.CENTER);
        rad3 = new JRadioButton();
        rad3.setEnabled(false);
        rad3.setOpaque(false);
        rad3.setHorizontalAlignment(JRadioButton.CENTER);
        rad4 = new JRadioButton();
        rad4.setEnabled(false);
        rad4.setOpaque(false);
        rad4.setHorizontalAlignment(JRadioButton.CENTER);
        rad5 = new JRadioButton();
        rad5.setEnabled(false);
        rad5.setOpaque(false);
        rad5.setHorizontalAlignment(JRadioButton.CENTER);
        rad6 = new JRadioButton();
        rad6.setEnabled(false);
        rad6.setOpaque(false);
        rad6.setHorizontalAlignment(JRadioButton.CENTER);
        rad7 = new JRadioButton();
        rad7.setEnabled(false);
        rad7.setOpaque(false);
        rad7.setHorizontalAlignment(JRadioButton.CENTER);

        radioGroup = new ButtonGroup();
        radioGroup.add(rad1);
        radioGroup.add(rad2);
        radioGroup.add(rad3);
        radioGroup.add(rad4);
        radioGroup.add(rad5);
        radioGroup.add(rad6);
        radioGroup.add(rad7);

        // Buttons
        ImageIcon guideIcon = new ImageIcon("GuideIcon.png"); //LIST OF FACILITIES/GUIDE BUTTON
        btnGuideIcon = new JButton(guideIcon);
        btnGuideIcon.setBounds(0, 20, 120, 50);
        btnGuideIcon.setFocusable(false);
        btnGuideIcon.setOpaque(false);
        btnGuideIcon.setBorderPainted(false);
        btnGuideIcon.setContentAreaFilled(false);
        btnGuideIcon.setText("Guide");
        btnGuideIcon.setForeground(Color.WHITE);
        btnGuideIcon.setFont(new Font("Arial", Font.BOLD, 15));
        btnGuideIcon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(false);
            }
        });

        ImageIcon searchIcon = new ImageIcon("SearchIcon.png"); //SEARCH PANEL BUTTON
        btnSearchIcon = new JButton(searchIcon);
        btnSearchIcon.setBounds(0, 20, 130, 50);
        btnSearchIcon.setFocusable(false);
        btnSearchIcon.setOpaque(false);
        btnSearchIcon.setBorderPainted(false);
        btnSearchIcon.setContentAreaFilled(false);
        btnSearchIcon.setText("Search");
        btnSearchIcon.setForeground(Color.WHITE);
        btnSearchIcon.setFont(new Font("Arial", Font.BOLD, 15));
        btnSearchIcon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(true);
            }
        });

        btnSearch = new JButton("Search"); // SEARCH BUTTON
        btnSearch.setFocusable(false);
        btnSearch.setBounds(95, 480, 300, 50);
        btnSearch.setBackground(new Color(160, 2, 2, 255));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Arial", Font.BOLD, 15));
        btnSearch.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        btnReset = new JButton("Reset"); // RESET BUTTON
        btnReset.setFocusable(false);
        btnReset.setBounds(95, 545, 300, 50);
        btnReset.setBackground(new Color(160, 2, 2, 255));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Arial", Font.BOLD, 15));
        btnReset.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        // Textfields
        field1 = new JTextField(); // SEARCH BAR
        field1.setFont(new Font("Arial", Font.BOLD, 13));
        field1.setBackground(Color.WHITE);
        field1.setForeground(Color.GRAY);
        field1.setBorder(BorderFactory.createLineBorder(new Color(241, 99, 99, 225)));
        field1.setBounds(40, 390, 410, 50);

        field2 = new JTextField(); // LOCATION DISPLAY (TOP OF MAIN PANEL)
        field2.setFont(new Font("Arial", Font.BOLD, 10));
        field2.setForeground(Color.BLACK);
        field2.setBackground(Color.WHITE);
        field2.setBorder(BorderFactory.createLineBorder(new Color(150, 18, 18, 255)));
        field2.setBounds(620, 35, 200, 30);
        field2.setEditable(false);
        field2.setHorizontalAlignment(SwingConstants.CENTER);

        field3 = new JTextField("FACILITY"); // NAME OF FACILITY DISPLAY
        field3.setFont(new Font("Arial", Font.BOLD, 27));
        field3.setForeground(new Color(150, 18, 18, 255));
        field3.setBackground(Color.WHITE);
        field3.setBounds(45, 380, 400, 30);
        field3.setBorder(null);
        field3.setEditable(false);

        // TextArea
        area1 = new JTextArea(); // DESCRIPTION AREA
        area1.setText("Facility descriptions will be displayed here.");
        area1.setLineWrap(true);
        area1.setFont(new Font("Arial", Font.PLAIN, 12));
        area1.setForeground(Color.BLACK);
        area1.setBackground(Color.WHITE);
        area1.setBounds(70, 445, 730, 60);
        area1.setBorder(null);
        area1.setEditable(false);

        area2 = new JTextArea(); // ROUTE AREA
        area2.setText("Textual Routes will be displayed here.");
        area2.setLineWrap(true);
        area2.setFont(new Font("Arial", Font.PLAIN, 12));
        area2.setForeground(Color.BLACK);
        area2.setBackground(Color.WHITE);
        area2.setBounds(70, 535, 730, 60);
        area2.setBorder(null);
        area2.setEditable(false);

        area3 = new JTextArea(); //GUIDE AREA 1
        area3.setText("Apolinario Mabini Shrine\n"
                + "PUP Obelisk\n"
                + "Pylon\n\n\n"
                + "Swimming Pool\n"
                + "Tennis Court\n"
                + "Gymnasium and Sport Center\n\n\n\n"
                + "Lagoon\n"
                + "Freedom Park\n"
                + "Interfaith Chapel\n\n\n\n\n\n"
                + "Guard House\n"
                + "Visitor Information Center\n"
                + "Water Pump Facility\n"
                + "R.C. Overhead Water Tank\n"
                + "PUP Sta. Mesa Ferry Station\n"
                + "Charlie Del Rosario Hall\n"
                + "Tahanan ng Alumni\n"
                + "PUP Souvenir Shop");
        area3.setLineWrap(true);
        area3.setFont(new Font("Arial", Font.PLAIN, 12));
        area3.setForeground(Color.WHITE);
        area3.setBackground(new Color(150, 18, 18, 255));
        area3.setBounds(25, 83, 260, 600);
        area3.setBorder(null);
        area3.setEditable(false);

        area4 = new JTextArea(); //GUIDE TITLE AREA 1
        area4.setText("Historical Sites\n\n\n\n"
                + "Sports Facilities\n\n\n\n"
                + "Student and \nCommunity Spaces\n\n\n\n\n"
                + "Administrative and \nService Buildings");
        area4.setLineWrap(true);
        area4.setFont(new Font("Arial", Font.BOLD, 15));
        area4.setForeground(Color.WHITE);
        area4.setBackground(new Color(150, 18, 18, 0));
        area4.setBounds(20, 62, 260, 600);
        area4.setBorder(null);
        area4.setEditable(false);

        area5 = new JTextArea(); //GUIDE AREA 2
        area5.setText("Student Canteen\n"
                + "University Canteen \n(Sampaguita Building)\n\n\n\n\n"
                + "Laboratory High School\n"
                + "Ninoy Aquino Library and \nLearning Resources Center\n"
                + "Nutrition and Food \nScience Building\n"
                + "Main Building\n"
                + "North Wing\n"
                + "East Wing\n"
                + "West Wing\n"
                + "South Wing\n\n\n"
                + "Grandstand\n"
                + "Track and Football Oval\n");
        area5.setLineWrap(true);
        area5.setFont(new Font("Arial", Font.PLAIN, 12));
        area5.setForeground(Color.WHITE);
        area5.setBackground(new Color(150, 18, 18, 255));
        area5.setBounds(250, 83, 260, 600);
        area5.setBorder(null);
        area5.setEditable(false);

        area6 = new JTextArea(); //GUIDE TITLE AREA 2
        area6.setText("Canteen\n\n\n\n"
                + "Academic and Learning \nFacilitiess\n\n\n\n\n\n\n\n\n\n"
                + "Oval\n\n\n\n\n");
        area6.setLineWrap(true);
        area6.setFont(new Font("Arial", Font.BOLD, 15));
        area6.setForeground(Color.WHITE);
        area6.setBackground(new Color(150, 18, 18, 0));
        area6.setBounds(245, 62, 260, 600);
        area6.setBorder(null);
        area6.setEditable(false);

        // Panels
        panel1 = new JPanel(); // BG OF SEARCH PANEL
        panel1.setBackground(new Color(194, 16, 16, 225));
        panel1.setBounds(0, 0, 515, 700);
        panel1.setLayout(null);

        panel2 = new JPanel(); // SEARCH PANEL
        panel2.setBackground(new Color(150, 18, 18, 255));
        panel2.setBounds(12, 12, 490, 640);
        panel2.setLayout(null);

        panel3 = new JPanel(); // MAIN PANEL
        panel3.setBackground(Color.WHITE);
        panel3.setBounds(520, 0, 1100, 700);
        panel3.setLayout(null);

        panel4 = new JPanel(); // FACILITY IMAGES PANEL
        panel4.setBackground(new Color(150, 18, 18, 0));
        panel4.setBounds(30, 80, 800, 290);
        panel4.setBorder(BorderFactory.createLineBorder(new Color(150, 18, 18, 255), 3, true));
        panel4.setLayout(null);

        panel5 = new JPanel(); // LOCATION LABEL PANEL
        panel5.setBackground(new Color(150, 18, 18, 255));
        panel5.setBounds(535, 35, 80, 30);

        panel6 = new JPanel(); // RADIOBUTTON PANEL
        panel6.setBounds(30, 620, 800, 30);
        panel6.setLayout(new GridLayout(1, 7));
        panel6.setBorder(BorderFactory.createLineBorder(new Color(150, 18, 18, 255), 1, true));
        panel6.setBackground(Color.WHITE);

        panel7 = new JPanel(); //GUIDE PANEL
        panel7.setBackground(new Color(150, 18, 18, 255));
        panel7.setBounds(12, 12, 490, 640);
        panel7.setLayout(null);

        panel8 = new JPanel(); //GUIDE TEXT PANEL
        panel8.setBackground(new Color(150, 18, 18, 255));
        panel8.setBounds(15, 60, 460, 630);
        panel8.setLayout(null);

        ImageIcon visitors = new ImageIcon("Intro.png");
        img1 = new JLabel(visitors); // FACILITY IMAGES PANEL
        img1.setBounds(30, 80, 800, 290);
        img1.setBorder(BorderFactory.createLineBorder(new Color(150, 18, 18, 255), 3, true));
        img1.setLayout(null);

        //Add
        panel8.add(area6);
        panel8.add(area5);
        panel8.add(area4);
        panel8.add(label12);
        panel8.add(area3);
        panel7.add(panel8);
        panel7.add(btnSearchIcon);
        panel6.add(rad1);
        panel6.add(rad2);
        panel6.add(rad3);
        panel6.add(rad4);
        panel6.add(rad5);
        panel6.add(rad6);
        panel6.add(rad7);
        panel5.add(label2);
        panel4.add(label8);
        panel3.add(label11);
        panel3.add(area2);
        panel3.add(label10);
        panel3.add(label9);
        panel3.add(area1);
        panel3.add(field3);
        panel3.add(panel6);
        panel3.add(field2);
        panel3.add(panel5);
        panel3.add(panel4);
        panel3.add(label6);
        panel3.add(label5);
        panel3.add(img1);
        panel2.add(btnGuideIcon);
        panel2.add(label1);
        panel2.add(label3);
        panel2.add(label4);
        panel2.add(field1);
        panel2.add(btnSearch);
        panel2.add(btnReset);
        panel2.add(label7);
        panel1.add(panel2);
        panel1.add(panel7);
        frame.add(panel3);
        frame.add(panel1);

        // Initialize slideshow components
        imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 800, 290);
        panel4.add(imageLabel);

        images = new ArrayList<>();
        imageLabels = new ArrayList<>();
        facilityNames = new ArrayList<>();
        descriptions = new ArrayList<>();
        routes = new ArrayList<>();
        mapImages = new ArrayList<>();

        // Load your images and labels here
        images.add(new ImageIcon(""));
        images.add(new ImageIcon("Pylon.png"));
        images.add(new ImageIcon("VisInfo.png"));
        images.add(new ImageIcon("Gymnasium.png"));
        images.add(new ImageIcon("Tennis Court.png"));
        images.add(new ImageIcon("Obelisk.png"));
        images.add(new ImageIcon("Swimming Pool.png"));
        images.add(new ImageIcon("Tahanan ng Alumni.png"));
        images.add(new ImageIcon("Guard House.png"));
        images.add(new ImageIcon("Gazebo.png"));
        images.add(new ImageIcon("Apolinario Shrine.png"));
        images.add(new ImageIcon("Freedom Park.png"));
        images.add(new ImageIcon("Grandstand.png"));
        images.add(new ImageIcon("Track and Football Oval.png"));
        images.add(new ImageIcon("Lagoon.png"));
        images.add(new ImageIcon("North Wing.png"));
        images.add(new ImageIcon("Interfaith Chapel.png"));
        images.add(new ImageIcon("NutFood.png"));
        images.add(new ImageIcon("East Wing.png"));
        images.add(new ImageIcon("West Wing.png"));
        images.add(new ImageIcon("South Wing.png"));
        images.add(new ImageIcon("Ferry Station.png"));
        images.add(new ImageIcon("Ninoy Library.png"));
        images.add(new ImageIcon("SampaguitaBuilding.png"));
        images.add(new ImageIcon("University Canteen.png"));
        images.add(new ImageIcon("Charlie.png"));
        images.add(new ImageIcon("Laboratory High School.png"));
        images.add(new ImageIcon("Overhead Water Tank.png"));
        images.add(new ImageIcon("Pumping Station.png"));

        // Add corresponding labels, facility names, descriptions, routes, and map images for the images
        imageLabels.add("");
        imageLabels.add("Pylon");
        imageLabels.add("Visitor Information Center");
        imageLabels.add("Gymnasium and Sports Center");
        imageLabels.add("Tennis Court");
        imageLabels.add("Mabini Monument PUP Obelisk");
        imageLabels.add("Swimming Pool");
        imageLabels.add("Tahanan ng Alumni");
        imageLabels.add("Guard House");
        imageLabels.add("Gazebo");
        imageLabels.add("Apolinario Mabini Shrine");
        imageLabels.add("Freedom Park");
        imageLabels.add("Grandstand");
        imageLabels.add("Track and Football Oval");
        imageLabels.add("Lagoon");
        imageLabels.add("North Wing");
        imageLabels.add("Interfaith Chapel");
        imageLabels.add("Nutrition and Food Science Building");
        imageLabels.add("East Wing");
        imageLabels.add("West Wing");
        imageLabels.add("South Wing");
        imageLabels.add("PUP Sta. Mesa Ferry Station");
        imageLabels.add("Ninoy Aquino Library and Learning Resources Center");
        imageLabels.add("Sampaguita Building");
        imageLabels.add("Student Canteen");
        imageLabels.add("Charlie Del Rosario Building");
        imageLabels.add("Laboratory High School");
        imageLabels.add("RC Overhead Water Tank");
        imageLabels.add("Water Pump Facility");


        facilityNames.add("");
        facilityNames.add("Pylon");
        facilityNames.add("Visitor Information Center");
        facilityNames.add("Gymnasium and Sports Center");
        facilityNames.add("Tennis Court");
        facilityNames.add("Mabini Monument PUP Obelisk");
        facilityNames.add("Swimming Pool");
        facilityNames.add("Tahanan ng Alumni");
        facilityNames.add("Guard House");
        facilityNames.add("PUP Souvenir Shop");
        facilityNames.add("Apolinario Mabini Shrine");
        facilityNames.add("Freedom Park");
        facilityNames.add("Grandstand");
        facilityNames.add("Track and Football Oval");
        facilityNames.add("Lagoon");
        facilityNames.add("North Wing");
        facilityNames.add("Interfaith Chapel");
        facilityNames.add("Nutrition and Food Science Building");
        facilityNames.add("East Wing");
        facilityNames.add("West Wing");
        facilityNames.add("South Wing");
        facilityNames.add("PUP Sta. Mesa Ferry Station");
        facilityNames.add("Ninoy Aquino Library and Learning Resources Center");
        facilityNames.add("University Canteen (Sampaguita Building)");
        facilityNames.add("Student Canteen");
        facilityNames.add("Charlie Del Rosario Building");
        facilityNames.add("Laboratory High School");
        facilityNames.add("RC Overhead Water Tank");
        facilityNames.add("Water Pump Facility");

        descriptions.add("");
        descriptions.add("Pylon [This triad of pillars erected beside the main gate of the campus once embodied wisdom, strength, and beauty because, according to PUP, 'there should be wisdom to contrive, strength to support, and beauty to adorn any great or important undertaking'. Now, this structure symbolizes truth, excellence, and wisdom.]");
        descriptions.add("Visitor Information Center [A dedicated facility that provides information and assistance to visitors of the campus. It offers campus maps, brochures, and directions and can answer questions about university events, facilities, and services.]");
        descriptions.add("Gymnasium and Sports Center [Located near the main gate of the university, the Gymnasium and Sports Center facilitates student-athlete training, intercollegiate sports events, physical education classes, and even important meetings or gatherings.]");
        descriptions.add("Tennis Court [Where the former Basketball and Volleyball Court once stood, this location was later reconstructed into the university's personal Tennis Court that enables regular students and student-athletes to harness, develop, and improve the proper related skillsets for the tennis sport.]");
        descriptions.add("Mabini Monument PUP Obelisk [Standing across the main gate is the Obelisk, which is a tall monument that symbolizes the strength of the Polytechnic University of the Philippines (PUP) in higher education. Signifying PUP as the Light of the Nation, the University Star Logo at the top of the Obelisk represents the search for truth and perfection. The five points of the aforementioned star embody PUP’s core values, which are integrity, ingenuity, industry, intelligence, and internationalism.]");
        descriptions.add("Swimming Pool [Complete with roofed bleachers for the audience, the university's Swimming Pool not only accommodates the swimming classes of regular students but also allows for the activities of student-athletes.]");
        descriptions.add("Tahanan ng Alumni [Built between the Physical Education Building and Campus Pool, the Tahanan ng Alumni serves as the established venue for alumni-related events or activities such as class reunions and local gatherings.]");
        descriptions.add("Guard House [Located near the main gate of the university, which serves as the primary security checkpoint to regulate and oversee the entry and exit of students, faculty, staff, and visitors. It also serves as information desks about the location of the rooms and buildings around the university and for the lost and found items.]");
        descriptions.add("PUP Souvenir Shop [Formerly known as the 'Gazebo' located near the campus catwalk where students, staff, and visitors can purchase a variety of PUP-branded merchandise from lanyards up to T-shirts made by Tanglaw Clothing.]");
        descriptions.add("Apolinario Mabini Shrine [Located near the PUP Souvenir Shop, this historical site and museum honors one of the country's most renowned heroes and former military leaders, Apolinario Mabini. It is reported that former military heroes stayed here during the Philippine Revolution.]");
        descriptions.add("Freedom Park [Also known as 'Freedom Plaza' that is in front of the Main Academic Building that was built for PUP's Centennial Year, which was celebrated in 2004. It serves as a recreational space for students where freedom of expression, creativity, and learning converge to enrich the university experience.]");
        descriptions.add("Grandstand [Located inside the university oval, it serves as a venue for various large-scale events and activities, such as intramural and intercollegiate competitions, graduation ceremonies, concerts, and mass. It can also serve as a bleacher where students can support and support their university team.]");
        descriptions.add("Track and Football Oval [It is located beside the main gate of the university, which serves as one of the university's facilities and provides a place for different activities such as physical education classes, intramural sports competitions, intercollegiate matches, and other events.]");
        descriptions.add("Lagoon [It is one of the go-to places on campus where students go in their free time, and all the different food stalls are located inside the lagoon and offer affordable food, snacks, and beverages. The ampitheater is also located near the lagoon.]");
        descriptions.add("North Wing [One of the main buildings on the campus that provides classrooms, offices, and facilities for academic activities. And currently under construction.]");
        descriptions.add("Interfaith Chapel [An Interfaith Chapel is a sacred space designed to provide a welcoming environment for people of all faiths and beliefs to come together for prayer, reflection, and meditation, fostering spiritual growth, understanding, and respect for diversity.]");
        descriptions.add("Nutrition and Food Sciences Building [A building dedicated to students and faculty under the nutrition and food sciences program equipped with laboratories, classrooms, and other facilities.]");
        descriptions.add("East Wing [One of the main buildings on the campus that provides classrooms, offices, and facilities for academic activities.]");
        descriptions.add("West Wing [One of the main buildings on the campus that provides classrooms, offices, and facilities for academic activities.]");
        descriptions.add("South Wing [One of the main buildings on the campus that provides classrooms, offices, and facilities for academic activities.]");
        descriptions.add("PUP Sta. Mesa Ferry Station [A transportation hub inside the campus that is accessible to everyone which provides ferry services and facilitates easy access for students and staff, and it is currently under renovation.]");
        descriptions.add("Ninoy Aquino Library and Learning Resources Center [The University Library and Learning Resource Center is one of the major service centers at the Polytechnic University of the Philippines. As such, it strives to meet its clientele's academic and related needs by providing adequate and efficient library and information services.]");
        descriptions.add("University Canteen (Sampaguita Building) [Located near Linear Park, One of the canteens in the university that offers variety of meals and snacks for students, faculty, and staff.]");
        descriptions.add("Student Canteen [Located near the University Canteen, students can buy various affordable meals, snacks, and beverages.]");
        descriptions.add("Charlie Del Rosario Building [It stands as a Freedom Hall Building in honor of the late Charlie del Rosario, also being used as a classroom and facility for students and faculty.]");
        descriptions.add("Laboratory High School [The PUP Laboratory High School (PUP LHS) was established in 1954 during the Philippine College of Commerce era. The PUP LHS curricular program focuses on Discipline, Academic Excellence, Nationalism, and Commerce. It is one of the top-performing high schools in the country, producing top-caliber students who later become prominent in their chosen fields of specialization.]");
        descriptions.add("RC Overhead Water Tank [An overhead-raised water storage system that stores and supplies water for the whole university ensures a reliable water supply.]");
        descriptions.add("Water Pump Facility [Located near the water tanks, which operate pumps to distribute water from storage tanks to different buildings and areas within the campus.]");

        routes.add("");
        routes.add("Route to Pylon: [After entering the university’s main gate, make a quick right turn to reach the pylon]");
        routes.add("Route to Visitor Information Center: [From the university’s main gate, walk straight ahead and after a few meters turn right to reach the Visitor Information Center]");
        routes.add("Route to Gymnasium and Sports Center: [From the university’s main gate, walk straight ahead and make a turn right after the visitor information center, then follow the covered walkway and make a turn left to reach the Gymnasium and Sports Center.]");
        routes.add("Route to Tennis Court: From the university’s main gate, walk straight towards the university’s catwalk and make a turn right to reach the tennis court.");
        routes.add("Route to Mabini Monument PUP Obelisk:[From the university’s main gate, walk straight ahead towards the university’s cat walk to reach the PUP Obelisk, which can be seen from afar. ] ");
        routes.add("Route to Swimming Pool:[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn right and walk straight ahead and lastly, make a turn right and walk straight ahead to reach the swimming pool.] ");
        routes.add("Route to Tahanan ng Alumni:[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn right and walk straight ahead to reach the Tahanan ng Alumni.] ");
        routes.add("Route to Guard House:[After entering the university's main gate, turn left, and you will see the guard house.] ");
        routes.add("Route to PUP Souvenir Shop:[From the main gate, walk straight ahead, and on the left side, you will see the PUP Souvenir Shop. ] ");
        routes.add("Route to Apolinario Mabini Shrine:[From the university’s main gate, walk straight ahead towards the PUP Souvenir Shop and turn left to the Apolinario Mabini Shrine.] ");
        routes.add("Route to Freedom Park:[From the university’s main gate, walk straight ahead towards the Mabini Monument PUP Obelisk and turn left to arrive at the Freedom Park.] ");
        routes.add("Route to Grandstand:[From the university’s main gate, walk towards the covered walkway, then turn left and walk straight ahead until you reach the main entrance of the university’s oval, and turn left to reach the university’s grandstand.] ");
        routes.add("Route to Track and Football Oval:[From the university’s main gate, walk towards the covered walkway, then turn left and walk straight ahead until you reach the main entrance of the university’s oval and walk straight ahead to arrive at the university’s track and football oval.] ");
        routes.add("Route to Lagoon:[From the university’s main gate, walk straight ahead until you reach the main entrance of the lagoon.] ");
        routes.add("Route to North Wing:[From the university’s main gate, walk towards the covered walkway, then turn left and walk straight ahead. After reaching the interfaith chapel, turn right to arrive at the North Wing Building.] ");
        routes.add("Route to Interfaith Chapel:[From the university’s main gate, walk towards the covered walkway, then turn left and walk straight ahead to arrive at the interfaith chapel.] ");
        routes.add("Route to Nutrition and Food Sciences Building:[From the university’s main gate, walk towards the covered walkway, then turn left and walk straight ahead. Upon reaching the interfaith chapel, turn left and walk straight ahead to reach the Nutrition and Food Sciences Building.] ");
        routes.add("Route to East Wing:[From the university’s main gate, walk towards the covered walkway, then turn left and walk straight ahead. After reaching the interfaith chapel, turn right, then go left to arrive at the East Wing Building.] ");
        routes.add("Route to West Wing:[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn left and walk straight ahead to reach the West Wing Building.] ");
        routes.add("Route to South Wing:[From the university’s main gate, walk towards the covered walkway, then turn left and walk straight ahead. After reaching the interfaith chapel, turn right. Upon turning right, turn left and walk straight to the main building to reach the South Wing Building.] ");
        routes.add("Route to PUP Sta. Mesa Ferry Station:[From the university’s main gate, walk towards the covered walkway, then turn left and walk straight ahead. Upon reaching the interfaith chapel, turn left and walk straight ahead, then turn left. Walk straight ahead and turn right to reach the PUP Sta. Mesa Ferry Station.] ");
        routes.add("Route to Ninoy Aquino Library and Learning Resources Center:[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn left and walk straight ahead. Upon reaching the west wing, turn right and walk straight ahead until you reach the Ninoy Aquino Library and Learning Resouces Center.] ");
        routes.add("Route to University Canteen (Sampaguita Building):[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn left and walk straight ahead to reach the University Canteen Sampaguita Building.] ");
        routes.add("Route to Student Canteen:[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn left and walk straight ahead to reach the Student Canteen beside the University Canteen Sampaguita Building.] ");
        routes.add("Route to Charlie Del Rosario Building:[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn left and walk straight ahead. Upon reaching the west wing, turn right and walk straight ahead, then turn left to reach the Charlie del Rosario Building. ] ");
        routes.add("Route to Laboratory High School:[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn left and walk straight ahead. Upon reaching the west wing, turn right and walk straight ahead. Upon reaching the Ninoy Aquino Library and Learning Resouces Center, turn left to arrive at the Laboratory High School.] ");
        routes.add("Route to RC Overhead Water Tank:[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn left and walk straight ahead. Upon reaching the west wing, turn right and walk straight ahead until you reach the Overhead water tank.] ");
        routes.add("Route to Water Pump Facility:[From the university’s main gate, walk straight ahead toward the PUP Obelisk, then turn left and walk straight ahead. Upon reaching the west wing, turn right and walk straight ahead until you reach the water pump facility at the end of the road.] ");

        mapImages.add(new ImageIcon(""));
        mapImages.add(new ImageIcon("PylonMap.png"));
        mapImages.add(new ImageIcon("VisitInfoMap.png"));
        mapImages.add(new ImageIcon("GymMap.png"));
        mapImages.add(new ImageIcon("TennisMap.png"));
        mapImages.add(new ImageIcon("ObeliskMap.png"));
        mapImages.add(new ImageIcon("PoolMap.png"));
        mapImages.add(new ImageIcon("AlumniMap.png"));
        mapImages.add(new ImageIcon("GuardHouseMap.png"));
        mapImages.add(new ImageIcon("SouvenirMap.jpg"));
        mapImages.add(new ImageIcon("MabiniShrineMap.png"));
        mapImages.add(new ImageIcon("FreedomParkMap.png"));
        mapImages.add(new ImageIcon("GrandstandMap.png"));
        mapImages.add(new ImageIcon("OvalMap.png"));
        mapImages.add(new ImageIcon("LagoonMap.png"));
        mapImages.add(new ImageIcon("NorthWingMap.png"));
        mapImages.add(new ImageIcon("ChapelMap.png"));
        mapImages.add(new ImageIcon("NatFoodMap.png"));
        mapImages.add(new ImageIcon("EastWingMap.png"));
        mapImages.add(new ImageIcon("WestWingMap.png"));
        mapImages.add(new ImageIcon("SouthWingMap.png"));
        mapImages.add(new ImageIcon("FerryStationMap.png"));
        mapImages.add(new ImageIcon("LibraryMap.png"));
        mapImages.add(new ImageIcon("SampaguitaMap.png"));
        mapImages.add(new ImageIcon("StudentCanteenMap.png"));
        mapImages.add(new ImageIcon("CharlieMap.png"));
        mapImages.add(new ImageIcon("LabHighMap.png"));
        mapImages.add(new ImageIcon("WaterTankMap.png"));
        mapImages.add(new ImageIcon("WaterPumpMap.png"));

        locationCategoryMap = new HashMap<>();
        locationCategoryMap.put("Pylon", "Historical Sites");
        locationCategoryMap.put("Apolinario Mabini Shrine", "Historical Sites");
        locationCategoryMap.put("PUP Obelisk", "Historical Sites");
        locationCategoryMap.put("Swimming Pool", "Sports Facilities");
        locationCategoryMap.put("Tennis Court", "Sports Facilities");
        locationCategoryMap.put("Gymnasium and Sports Center", "Sports Facilities");
        locationCategoryMap.put("Lagoon", "Students and Community Spaces");
        locationCategoryMap.put("Freedom Park", "Students and Community Spaces");
        locationCategoryMap.put("Interfaith Chapel", "Students and Community Spaces");
        locationCategoryMap.put("Guard House", "Administrative and Service Buildings");
        locationCategoryMap.put("Water Pump Facility", "Administrative and Service Buildings");
        locationCategoryMap.put("R.C. Overhead Water Tank", "Administrative and Service Buildings");
        locationCategoryMap.put("R.C. Underground Water Tank", "Administrative and Service Buildings");
        locationCategoryMap.put("PUP Sta. Mesa Ferry Station", "Administrative and Service Buildings");
        locationCategoryMap.put("Charlie Del Rosario Building", "Administrative and Service Buildings");
        locationCategoryMap.put("Tahanan ng Alumni", "Administrative and Service Buildings");
        locationCategoryMap.put("PUP Souvenir Shop", "Administrative and Service Buildings");
        locationCategoryMap.put("Visitor Information Center", "Administrative and Service Buildings");
        locationCategoryMap.put("Student Canteen", "Canteen");
        locationCategoryMap.put("Sampaguita Building", "Canteen");
        locationCategoryMap.put("Laboratory High School", "Academic and Learning Facilities");
        locationCategoryMap.put("Ninoy Aquino Library and Learning Resources Center", "Academic and Learning Facilities");
        locationCategoryMap.put("Nutrition and Food Science Building", "Academic and Learning Facilities");
        locationCategoryMap.put("North Wing", "Academic and Learning Facilities");
        locationCategoryMap.put("East Wing", "Academic and Learning Facilities");
        locationCategoryMap.put("West Wing", "Academic and Learning Facilities");
        locationCategoryMap.put("South Wing", "Academic and Learning Facilities");
        locationCategoryMap.put("Grandstand", "Oval");
        locationCategoryMap.put("Track and Football Oval", "Oval");

        currentImageIndex = 0;
        updateSlideshow();

        // Search button action

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = field1.getText().trim();
                if (location.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter a location.",
                            "Empty Input",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (String key : locationCategoryMap.keySet()) {
                    if (key.equalsIgnoreCase(location)) {
                        field2.setText(locationCategoryMap.get(key));
                        startSlideshow(key);
                        return;
                    }
                }

                field2.setText("Category not found");
                JOptionPane.showMessageDialog(frame,
                        "The location '" + location + "' does not exist.",
                        "Location Not Found",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field1.setText("");
                area1.setText("Facility descriptions will be displayed here.");
                area2.setText("Textual Routes will be displayed here.");
                label1.setIcon(new ImageIcon("ColoredMap.jpg"));
                field2.setText("");
                btnSearchIcon.setEnabled(true);
                field1.setEnabled(true);
                resetSlideshow();
            }
        });

        frame.setVisible(true);
    }

    private void startSlideshow(String searchString) {
        if (timer != null) {
            timer.stop();
        }
        field1.setEnabled(false);

        // Hide the facility, description, and route areas
        field3.setVisible(false);
        area1.setVisible(false);
        area2.setVisible(false);

        // Hide the map image and show the searching text
        label1.setVisible(false);
        JLabel searchingLabel = new JLabel(searchingMapsText);
        searchingLabel.setForeground(Color.WHITE);
        searchingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        searchingLabel.setForeground(new Color(255, 255, 255, 255));
        searchingLabel.setBounds(label1.getBounds());
        searchingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchingLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Ensure the searchingLabel is only added once
        if (panel2.getComponentZOrder(searchingLabel) == -1) {
            panel2.add(searchingLabel);
        }

        // Show the searching text in other areas
        field3.setText(searchingText);
        area1.setText(searchingText);
        area2.setText(searchingText);
        field3.setVisible(true);
        area1.setVisible(true);
        area2.setVisible(true);

        currentImageIndex = 0; // Start from the first image

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentImageIndex < images.size()) {
                    if (imageLabels.get(currentImageIndex).equalsIgnoreCase(searchString)) {
                        timer.stop();
                        panel2.remove(searchingLabel);
                        updateFacilityInfo(currentImageIndex);
                        btnSearch.setEnabled(false);
                    } else {
                        currentImageIndex++;
                        updateSlideshow();
                    }
                } else {
                    timer.stop();
                    panel2.remove(searchingLabel);
                    panel2.revalidate();
                    panel2.repaint();
                }
            }
        });
        timer.start();
    }

    private void resetSlideshow() {
        if (timer != null) {
            timer.stop();
        }
        currentImageIndex = 0;
        updateSlideshow();
        img1.setIcon(new ImageIcon("Intro.png"));
        radioGroup.clearSelection();
        btnSearch.setEnabled(true);
        field3.setText("FACILITY");

    }
    private void updateSlideshow() {
        imageLabel.setIcon(images.get(currentImageIndex));
        // Update radio buttons
        switch (currentImageIndex % 7) {
            case 0:
                rad1.setSelected(true);
                break;
            case 1:
                rad2.setSelected(true);
                break;
            case 2:
                rad3.setSelected(true);
                break;
            case 3:
                rad4.setSelected(true);
                break;
            case 4:
                rad5.setSelected(true);
                break;
            case 5:
                rad6.setSelected(true);
                break;
            case 6:
                rad7.setSelected(true);
                break;
        }
    }

    private void updateFacilityInfo(int index) {
        // Hide the searching text
        field3.setVisible(false);
        area1.setVisible(false);
        area2.setVisible(false);

        // Show the facility, description, and route areas
        field3.setText(facilityNames.get(index));
        area1.setText(descriptions.get(index));
        area2.setText(routes.get(index));
        field3.setVisible(true);
        area1.setVisible(true);
        area2.setVisible(true);

        // Show the map image
        label1.setIcon(mapImages.get(index));
        label1.setVisible(true);
    }

    public static void main(String[] args) {
        new ProjUnipoint();
    }
}
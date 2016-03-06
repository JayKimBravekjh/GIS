
//    // map event listener
//    map.addMapEventListener(new MapEventListenerAdapter() {
//        @Override
//        public void mapReady(MapEvent arg0) {
//            txtStatus.append("Map is ready.\n");
//            map.setExtent(new Envelope(-15967900, 1670500, -6360000, 8079000));
//        }

//        @Override
//        public void mapExtentChanged(MapEvent arg0) {
//            txtStatus.append("Map extent has changed.\n");
//        }
//    });


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box; 
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.esri.core.geometry.Envelope;
import com.esri.map.ArcGISTiledMapServiceLayer;
import com.esri.map.JMap;
import com.esri.map.MapEvent;
import com.esri.map.MapEventListener;
import com.esri.map.MapEventListenerAdapter;


public class MapEventsApp { 
    private final Color BG_COLOR = new Color(0, 0, 0, 255);
    private static final int BUTTON_WIDTH = 220;
    
    final static int panAmount = 1000000;
    
    final static String URL_WORLD_BASEMAP = "http://services.arcgisonline.com/ArcGIS/rest/services/NatGeo_Wo"
    
    private JMap map;
    
    public MapEventsApp() { 
    }
    
    public JComponent createUI()  throws Exception { 
      JComponent contentPane = createContentPane();
      
      map = createMap();
      
      JTextField txtTitle = new JTextField();
      txtTitle.setText("Map Events");
      txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
      txtTitle.setFont(new Font(txtTitle.getFont().getName(), txtTitle.getFont().getStyle(), 16)
      txtTitle.setMaximumSize(new Dimension(BUTTON_WIDTH + 10. 30));
      txtTitle.setBackground(BG_COLOR);
      txtTitle.setForeground(Color.WHITE);
      txtTitle.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
      
      final JTextArea txtStatus = new JTextArea();
      txtStatus.setLineWrap(true);
      txtStatus.setWrapStyleWord(true);
      txtStatus.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
      txtStatus.setMinimumSize(new Dimension(BUTTON_WIDTH, 150));
      txtStatus.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
      JScrollPane scrollPane = new JScrollPane(txtStatus);
      
      map.addMapEventListener(new MapEventListenerAdapter(){
         @Override
         public void mapReady(MapEvent arg0){
           txtStatus.append("Map is ready.\n");
         }
         
         @Override
         public void mapExtentChanged(MapEvent arg0){
           txtStatus.append("Map extent has changed.\n");
         }
      });
      
      JButton btnUSExtent = new JButton("Focus on U.S.");
      btnUSExtent.setMaximumSize(new Dimension(BUTTON_WIDTH, 25));
      btnUSExtent.setMinimumSize(new Dimension(BUTTON_WIDTH, 25));
      btnUSExtent.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { 
           map.setExtent(new Envelope(-15967900, 1670500, -6360000, 8079000));
         }
      });
      btnUSExtent.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      JButton btnZoom = new JButton("Zoom in");
      btnZoom.setMaximumSize(new Dimension(BUTTON_WIDTH, 25));
      btnZoom.setMinimumSize(new Dimension(BUTTON_WIDTH, 25));
      btnZoom.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { 
           map.zoom(0.8);
         }
      });
      btnZoom.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      JButton btnPanLeft = new JButton("Pan Left");
      btnPanLeft.setMaximumSize(new Dimension(BUTTON_WIDTH, 25));
      btnPanLeft.setMinimumSize(new Dimension(BUTTON_WIDTH, 25));
      btnPanLeft.addActionListener(new ActionListener() { 
         @Override
         public void actionPerformed(ActionEvent e) { 
           Envelop extent = map.getExtent();
           extent.setXMin(extent.getMin() - panAmount);
           map.panTo(extent);
         }
      });
      btnPanLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      JButton btnClear = new JButton("Clear Text Area");
      btnClear.setMaximumSize(new Dimension(BUTTON_WIDTH, 25));
      btnClear.setMinimumSize(new Dimension(BUTTON_WIDTH, 25));
      btnClear.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
           txtStatus.setText("");
         }
      });
      btnClear.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      JButton btnScale = new JButton("Set scale 1:100000");
      btnScale.setMaximumSize(new Dimension(BUTTON_WIDTH, 25));
      btnScale.setMinimumSize(new Dimension(BUTTON_WIDTH, 25));
      btnScale.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
           map.setScale(100000);
         }
      });
      btnScale.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      JButton btnFull = new JButton("Full extent");
      btnFull.setMaximumSize(new Dimension(BUTTON_WIDTH, 25));
      btnFull.setMinimumSize(new Dimension(BUTTON_WIDTH, 25));
      btnFull.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { 
           map.setFullExtent(map.getFullExtent());
         }
      });
      btnFull.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      final JPanel controlPanel = new JPanel();
      BoxLayout boxLayout = new BoxLayout(controlPanel, BoxLayout.Y_AXIS);
      controlPanel.setLayout(boxLayout);
      controlPanel.setLocation(10, 10);
      controlPanel.setSize(BUTTON_WIDTH + 10, 400);
      controlPanel.setBackground(new Color(0, 0, 0, 100));
      controlPanel.setBorder(new Line Border(Color.BLACK, 3, false));
      
      controlPanel.add(txtTitle);
      controlPanel.add(Box.createVerticalStrut(5));
      controlPanel.add(btnUSExtent);
      controlPanel.add(Box.createVerticalStrut(5));
      controlPanel.add(btnZoom);
      controlPanel.add(Box.createVerticalStrut(5));
      controlPanel.add(btnPanLeft);
      controlPanel.add(Box.createVerticalStrut(5));
      controlPanel.add(btnScale);
      controlPanel.add(Box.createVerticalStrut(5));
      controlPanel.add(btnFull);
      
      controlPanel.add(Box.createVerticalStrut(5));
      controlPanel.add(scrollPane);
      controlPanel.add(Box.createVerticalStrut(5));
      controlPanel.add(btnClear);
      controlPanel.add(Box.createVerticalStrut(5));
      
      contentPane.add(map);
      
      return contentPane;
    }
    
    
           
    public static void main(String[] args){
      SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run(){
          try {
            MapEventsApp mapEventsApp = new MapEventsApp();
            
            JFrame appWindow = mapEventsApp.createWindow();
            appWindow.add(mapEventsApp.createUI());
            appWindow.setVisible(true);
          } catch (Exception e) { 
            e.printStackTrace();
          }
        }
    });
  }
  
  private JFrame createWindow(){
    JFrame window = new JFrame("Map Events Application");
    window.setBounds(100, 100, 1000, 700);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setLayout(new BorderLayout(0, 0));
    window.addWindowListener(new WindowAdapter(){
      @Override
      public void windowClosing(WindowEvent windowEvent){
        super.windowClosing(windowEvent);
        map.dispose();
      }
    });
    return window;
  }
  
  private static JLayeredPane createContentPane(){
    JLayeredPane contentPane = new JLayeredPane();
    contentPane.setBounds(100, 100, 1000, 700);
    contentPane.setLayout(new BorderLayout(0, 0));
    contentPane.setVisible(true);
    return contentPane;
  }
  
  private JMap createMap()  throws Exception {
    final JMap jMap = new JMap();
    jMap.setExtent(new Envelope(-15967900, 1670500, -636000, 8079000)
    
    final ArcGISTiledMapServiceLayer baseLayer = new ArcGISTiledMapServiceLayer(URL_WORLD_BASEMAP);
    jMap.getLayers().add(baseLayer);
    
    return jMap;
  }
}






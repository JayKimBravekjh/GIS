//// code snippet
//// map options: topographic map, centered at lat-lon 41.9, 12.5 (Rome), zoom level 12
//MapOptions mapOptions = new MapOptions(MapType.TOPO, 41.9000, 12.5000, 12);

//// create the map using MapOptions 
//map = new JMap(mapOptions);
//contentPane.add(map);

//// add marker graphics directly to the map
//map.addMarkerGraphic(41.912402, 12.484778, "Villa Borghese", "Lovely park in the center of Rome.");

//// Sample Code

package com.esri.client.samples.map; 

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing,SwingUtilities;

import com.esri.map.JMap;
import com.esri.map.MapOptions;
import com.esri.map.MapOptions.MapType;

public class SimpleMap {
   private JMap map;
   
   // default constructor
   public SimpleMap() {  } 
   
   // Core functionality
   
   /Create and displays the UI, including the map, for this application. 

public JComponent createUI()  throws Exception { 

   // application content
   JPanel contentPane = new JPanel(new BorderLayout());
   
   // map options: topographic map, centered at lat-lon 41.9, 12.5 (Rome)
   MapOptions mapOptions = new MapOptions(MapType.TOPO, 41.9000, 12.5000.
   
   // create the map using MapOptions 
   map = new JMap(mapOptions);
   contentPane.add(map);
   
   // add marker graphics directly to the map
   map.addMarkerGraphic(41.899548, 12.476858.
        "Pantheon",
        "Built during the reign of Augustus as a temple to all the gods of 
        "http://www.neotryte.com/images/roma2_th.jpg",
        "http://en.wikipedia.org/wiki/Pantheon,_Rome", imgMarker);
  
   return contentPane;
}
 
public static void main(String[]  args) { 
   SwingUtilities.invokeLater(new Runnable() { 
        @Override
        public void run() { 
          try {
            // instance of this application
            SimpleMap mapExtentApp = new SimpleMap();
            // create the UI, including the map, for the application.
            JFrame appWindow = mapExtentApp.createWindow();
            appWindow.add(mapExtentApp.createUI());
            appWindow.setVisible(true);
          } catch (Exception e) {
            // on any error, display the stack trace.
            e.printStackTrace();
          }
        }
    });
}
        
private JFrame createWindow(){
   JFrame window = new JFrame("Basic Map Application");
   window.setSize(1000, 600);
   window.setLocationRelativeTo(null);
   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   window.getContentPane().setLayout(new BorderLayout());
   window.addWindowListener(new WindowAdapter() { 
      @Override
      public void windowClosing(WindowEvent windowEvent){
         super.windowClosing(windowEvent);
         map.dispose();
        }
    });
   return window;
  }
}



package guiComponents.pages;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import guiComponents.MainFrame;
import guiComponents.pages.home.HomeDates;
import guiComponents.specifics.DateButton;
import logic.theater.TheaterHouse;

//home page
public class PageHome extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//logic
	private TheaterHouse theaterHouse;
	private int numberDays; //number of days to be shown
	
	//gui
	private JPanel panelMain;
	private JPanel panelTop;
	private DateButton[] dateButton;
	private JScrollPane panelCenter;
	private JPanel panelDatesContainer;
	private HomeDates[] homeDates;
	
	public PageHome(TheaterHouse theaterHouse){
		this.theaterHouse = theaterHouse;
		numberDays = 7;
		
		this.setOpaque(false);
		this.setBorder(null);
		
		initializePanelMain();
		this.add(panelMain);
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	private void initializePanelMain(){
		panelMain = new JPanel();
		
		panelMain.setOpaque(false);
		panelMain.setLayout(new BorderLayout());
		
		initializePanelTop();
		initializePanelCenter();
		
		panelMain.add(panelTop, BorderLayout.NORTH);
		panelMain.add(panelCenter, BorderLayout.CENTER);
	}
	
	private void initializePanelTop(){
		panelTop = new JPanel();
		
		panelTop.setOpaque(false);
		panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.X_AXIS));
		panelTop.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTop.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, MainFrame.colorDarkMid));
		
		dateButton = new DateButton[numberDays];
		for(int i = 0; i < dateButton.length; i++){
			dateButton[i] = new DateButton(i, this);
			panelTop.add(dateButton[i]);
		}
		dateButton[0].pressedBG();
	}
	
	private void initializeHomeDates(){
		homeDates = new HomeDates[numberDays];
		
		for(int i = 0; i < homeDates.length; i++){
			homeDates[i] = new HomeDates(theaterHouse, i);
		}
	}
	
	private void initializePanelCenter(){
		initializeHomeDates();
		panelDatesContainer = new JPanel();
		panelDatesContainer.setOpaque(true);
		panelDatesContainer.setBackground(MainFrame.colorDark);
		panelDatesContainer.setBorder(BorderFactory.createEmptyBorder());
		panelDatesContainer.add(homeDates[0]);
		
		panelCenter = new JScrollPane(panelDatesContainer);
		panelCenter.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		panelCenter.setOpaque(false);
		panelCenter.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    panelCenter.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
	    	@Override
	        protected void configureScrollBarColors() {
	            this.thumbColor = MainFrame.colorDarkMid; // scroll thumb
	            this.trackColor = MainFrame.colorDark; // track background
	        }
	    });
	    panelCenter.getVerticalScrollBar().setUnitIncrement(10);
	    Dimension dim = MainFrame.getFrame().getSize();
	    dim.height = 500;
		panelCenter.setPreferredSize(dim);
		
	}
	
	//switches pages, to be used by the date buttons
	public void setDatesContainer(int i){
		panelDatesContainer.removeAll();
		panelDatesContainer.add(homeDates[i]);
		
		for(int j = 0; j < dateButton.length; j++){
			if(j != i) dateButton[j].unPress();
		}
		
		panelDatesContainer.setVisible(true);
		panelDatesContainer.revalidate();
		panelDatesContainer.repaint();
	}
	
	
}
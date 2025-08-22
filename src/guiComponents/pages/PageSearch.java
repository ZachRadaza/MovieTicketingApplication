package guiComponents.pages;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import guiComponents.MainFrame;
import logic.movies.Movie;

public class PageSearch extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//logic
	private String input; //input of the user in the search
	private ArrayList<Movie> movieListSearch; //list of movies that match the search
	private Movie[] movieList;
	
	//gui
	private JPanel panelMain;
	private JScrollPane panelMainCont;
	
	public PageSearch(String input, ArrayList<Movie> movieList){
		this.input = input;
		this.movieListSearch = new ArrayList<>();
		this.movieList = new Movie[movieList.size()];
		for(int i = 0; i < movieList.size(); i++){
			this.movieList[i] = movieList.get(i);
		}
		
		this.setOpaque(false);
		search();
		
		panelMain = new JPanel();
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		panelMain.setBackground(MainFrame.colorDark);
		panelMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//add things
		panelMain.add(createPanelInput());
		panelMain.add(createPanelSearch());
		
		panelMainCont = new JScrollPane(panelMain);
		
		panelMainCont.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		panelMainCont.setOpaque(false);
		panelMainCont.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    panelMainCont.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
	    	@Override
	        protected void configureScrollBarColors() {
	            this.thumbColor = MainFrame.colorDarkMid; // scroll thumb
	            this.trackColor = MainFrame.colorDark; // track background
	        }
	    });
	    panelMainCont.getVerticalScrollBar().setUnitIncrement(10);
	    Dimension dim = MainFrame.getFrame().getSize();
	    dim.height = 550;
		panelMainCont.setPreferredSize(dim);
		
		this.add(panelMainCont);
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
		
	}
	
	//adds things to the movie list
	private void search(){
		ArrayList<String> wordList = keywordsInput();
		
		for(int i = 0; i < wordList.size(); i++){
			searchWord(wordList.get(i));
		}
		
		
	}
	
	//separates the words the inputed/searched word
	private ArrayList<String> keywordsInput(){
		ArrayList<String> ret = new ArrayList<>();
		Scanner scanner = new Scanner(input);
		scanner.useDelimiter(" ");
		
		while(scanner.hasNext()){
			ret.add(scanner.next());
		}
		
		scanner.close();
		return ret;
	}
	
	//searches if the word is in a title of the movie list
	private void searchWord(String word){
		for(int i = 0; i < movieList.length; i++){
			if(movieList[i].getTitle().toUpperCase().contains(word.toUpperCase().trim())) movieListSearch.add(movieList[i]);
		}
	}
	
	private JPanel createPanelInput(){ //little input thing at the top with the inputted word
		JPanel panel = new JPanel();
		
		panel.setOpaque(false);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, MainFrame.colorDarkMid));
		
		String s = "Search results for \"" + input + "\"";
		if(movieListSearch.isEmpty()) s = "No results for \"" + input + "\"";
		
		JLabel label = new JLabel(s.toUpperCase());
		label.setForeground(MainFrame.colorLight);
		label.setFont(MainFrame.fontText.deriveFont(30f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		int bor = 10;
		label.setBorder(BorderFactory.createEmptyBorder(bor, bor, bor, bor));
		
		panel.add(label);
		
		Dimension dim = panel.getPreferredSize();
		panel.setPreferredSize(dim);
		
		return panel;
	}
	
	private JPanel createPanelSearch(){
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		search();
		
		if(movieListSearch.isEmpty()) panel.add(createPanelEmpty());
		else createPanelFound();
		
		return panel;
	}
	
	//jpanel shown when there is nothing that matches the search
	private JPanel createPanelEmpty(){
		JPanel panel = new JPanel();
		
		panel.setOpaque(false);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		String s = "We Could Not Find Any Results For \"" + input + "\". Please Try Again";
		JLabel label = new JLabel(s.toUpperCase());
		label.setForeground(MainFrame.colorLight);
		label.setFont(MainFrame.fontHeader.deriveFont(15f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(label);
		
		Dimension dim = MainFrame.getFrame().getSize();
		dim.height = 350;
		label.setSize(dim);
		
		return panel;
	}
	
	//panel shown when there are matches to the search
	private JPanel createPanelFound(){
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		
		return panel;
	}
	
}
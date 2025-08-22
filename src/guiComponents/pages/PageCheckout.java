package guiComponents.pages;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import guiComponents.MainFrame;
import guiComponents.specifics.BackButtonPageCheckout;
import guiComponents.specifics.NextButtonPageCheckout;

public class PageCheckout extends JPanel{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//logic
	private PageSeats pageSeats;
	private final float price = 11.99f;
	
	//gui
	private JPanel panelMain;

	public PageCheckout(PageSeats pageSeats){
		this.pageSeats = pageSeats;
		
		this.setOpaque(false);
		
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
		
		panelMain.add(createPanelTop(), BorderLayout.NORTH);
		panelMain.add(createPanelCenter(), BorderLayout.CENTER);
		panelMain.add(createPanelBottom(), BorderLayout.SOUTH);
		
		Dimension dim = panelMain.getPreferredSize();
		dim.height = 550;
		panelMain.setPreferredSize(dim);
	}
	
	private JPanel createPanelTop(){
		JPanel panel = new JPanel();
		
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new BorderLayout());
		
		//back button
		BackButtonPageCheckout backButton = new BackButtonPageCheckout(pageSeats);
		
		//label
		JLabel label = new JLabel("Ticket Checkout");
		label.setForeground(MainFrame.colorLight);
		label.setFont(MainFrame.fontHeader.deriveFont(15f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(backButton, BorderLayout.WEST);
		panel.add(label, BorderLayout.CENTER);
		
		Dimension dim = panel.getPreferredSize();
		dim.width = MainFrame.getFrame().getSize().width - 20;
		panel.setPreferredSize(dim);
		
		return panel;
	}
	
	private JPanel createPanelCenter(){
		JPanel panel = new JPanel();
		
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, MainFrame.colorDarkMid));
		
		panel.add(createPanelReview());
		panel.add(createPanelTotal());
	
		Dimension dim = panel.getPreferredSize();
		dim.width = MainFrame.getFrame().getSize().width - 20;
		panel.setPreferredSize(dim);
		
		return panel;
	}
	
	private JPanel createPanelReview(){
		JPanel panelReview = new JPanel();
		panelReview.setOpaque(false);
		panelReview.setLayout(new BoxLayout(panelReview, BoxLayout.Y_AXIS));
		panelReview.setAlignmentX(Component.CENTER_ALIGNMENT);
		int bor = 10;
		panelReview.setBorder(BorderFactory.createEmptyBorder(125, bor, bor, bor)); //125 due to setalightmenty not working
		
		//review tickets
		JLabel labelReview = new JLabel("Review Your Tickets".toUpperCase());
		labelReview.setForeground(MainFrame.colorLight);
		labelReview.setFont(MainFrame.fontHeader.deriveFont(30f));
		
		//seats
		String stringSeats = "Seats: ";
		for(int i = 0; i < pageSeats.getNumberOfTickets(); i++){
			stringSeats += pageSeats.getTicketList(i);
			if(i < pageSeats.getNumberOfTickets() - 1) stringSeats += ", ";
		}
		JLabel labelSeats = new JLabel(stringSeats);
		labelSeats.setForeground(MainFrame.colorLight);
		labelSeats.setFont(MainFrame.fontSubHeader.deriveFont(20f));
		
		panelReview.add(labelReview);
		panelReview.add(labelSeats);
		
		Dimension dim = panelReview.getPreferredSize();
		panelReview.setPreferredSize(dim);
		
		return panelReview;
	}
	
	private JPanel createPanelTotal(){
		JPanel panelTotal = new JPanel();
		panelTotal.setOpaque(false);
		panelTotal.setLayout(new BoxLayout(panelTotal, BoxLayout.Y_AXIS));
		int bor = 10;
		panelTotal.setBorder(BorderFactory.createEmptyBorder(bor, bor, bor, bor));
		panelTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		String stringTickets = pageSeats.getNumberOfTickets() + " Ticket".toUpperCase();
		if(pageSeats.getNumberOfTickets() > 1) stringTickets += "S".toUpperCase();
		JLabel tickets = new JLabel(stringTickets);
		tickets.setForeground(MainFrame.colorLight);
		tickets.setFont(MainFrame.fontHeader.deriveFont(20f));
		
		String stringBreakdown = "$" + price + " - x" + pageSeats.getNumberOfTickets() + " Tickets";
		JLabel breakdown = new JLabel(stringBreakdown);
		breakdown.setForeground(MainFrame.colorLight);
		breakdown.setFont(MainFrame.fontText.deriveFont(15f));
		
		String stringTotal = "Total: $" + (price * pageSeats.getNumberOfTickets());
		JLabel total = new JLabel(stringTotal);
		total.setForeground(MainFrame.colorLight);
		total.setFont(MainFrame.fontHeader.deriveFont(30f));
		
		panelTotal.add(tickets);
		panelTotal.add(breakdown);
		panelTotal.add(total);
		
		Dimension dim = panelTotal.getPreferredSize();
		panelTotal.setPreferredSize(dim);
		
		return panelTotal;
	}
	
	private JPanel createPanelBottom(){
		JPanel panel = new JPanel();
		
		panel.setOpaque(false);
		
		panel.add(new NextButtonPageCheckout());
		
		Dimension dim = panel.getPreferredSize();
		dim.width = MainFrame.getFrame().getSize().width - 20;
		panel.setPreferredSize(dim);
		
		return panel;
	}
}
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IModel;

class ViewPanel extends JPanel implements Observer {
	private IModel model;

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame, IModel model) {
		this.model=model;
		this.setViewFrame(viewFrame);
	}

	private String intToString(int score) {
		// TODO Auto-generated method stub
		return ""+ score;
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setFont(new Font("impact", Font.BOLD, 45));
		graphics.setColor(new Color(255,0,0));
		
			for(int x=0;x<25;x++){		   
			for (int y=0;y<25;y++){
				graphics.drawImage((this.getViewFrame().getModel().getLevel()[x][y].getSprite().getImage()), x*this.getWidth()/24, y*this.getHeight()/24,this.getWidth()/24, this.getHeight()/24, this);
				
					
							
			}			
		}
			graphics.drawString(intToString(model.getPlayerPosition().getScore()),  (24*this.getWidth()/25),  (1*this.getHeight()/25)+5);
	}
}

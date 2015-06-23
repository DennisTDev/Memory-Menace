package com.GrayBlack.memorymenace;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.GrayBlack.memorymenace.Game.STATE;
import com.GrayBlack.memorymenace.Game.TCONFIG;
import com.GrayBlack.memorymenace.Game.ACONFIG;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();

		if (Game.State == STATE.MENU) {
			if (mx >= 500 && mx <= 918) {
				if (my >= 200 && my <= 269) {
					Game.State = Game.State.OPTIONS;
				}
			}
			if (mx >= 500 && mx <= 918) {
				if (my >= 275 && my <= 344) {
					Game.State = Game.State.INSTRUCTIONS;
				}
			}
			if (mx >= 500 && mx <= 917) {
				if (my >= 350 && my <= 419) {
					Game.State = Game.State.CREDITS;
				}
			}
		}
		else if (Game.State == STATE.OPTIONS) {
			
			if (mx >= 30 && mx <= 121) {
				if (my >= 700 && my <= 743) {
					Game.State = Game.State.MENU;
				}
			}
			if (mx >= 150 && mx <= 450) {
				if (my >= 260 && my <= 357) {
					Game.Theme = Game.Theme.CLASSIC;
				}
			}
			if (mx >= 500 && mx <= 800) {
				if (my >= 260 && my <= 357) {
					Game.Theme = Game.Theme.MAPLE;
				}
			}
			if (mx >= 850 && mx <= 1150) {
				if (my >= 260 && my <= 357) {
					Game.Theme = Game.Theme.LEAGUE;
				}
			}
			if (mx >= 540 && mx <= 640) {
				if (my >= 370 && my <= 445) {
					Game.Area = Game.Area.SMALL;
				}
			}
			if (mx >= 740 && mx <= 840) {
				if (my >= 370 && my <= 445) {
					Game.Area = Game.Area.REG;
				}
			}
			if (mx >= 940 && mx <= 1040) {
				if (my >= 370 && my <= 445) {
					Game.Area = Game.Area.LARGE;
				}
			}
			if (mx >= 550 && mx <= 858) {
				if (my >= 550 && my <= 669) {
					Game.State = Game.State.GAME;
				}
			}

		}

		else if (Game.State == STATE.INSTRUCTIONS || Game.State == STATE.CREDITS) {
			if (mx >= 30 && mx <= 121) {
				if (my >= 700 && my <= 743) {
					Game.State = Game.State.MENU;
				}
			}
		}

		else if (Game.State == STATE.GAME) {
			if (mx >= 30 && mx <= 121) {
				if (my >= 700 && my <= 743) {
					Game.State = Game.State.MENU;
				}
			}
			
			if (mx >= 30 && mx <= 121) {
				if (my >= 700 && my <= 743) {
					Game.State = Game.State.OPTIONS;
				}
			}

			if (Game.Area == ACONFIG.SMALL) {
				int x = 0, y = 0;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (mx >= 400 + x && mx <= 500 + x) {
							if (my >= 10 + y && my <= 157 + y) {
								// //////////////////////////
								Game.State = Game.State.OPTIONS;
								// //////////////////////////
							}
						}
						
						x += 200;
					}
					x=0;
					y += 200;
					
					
				}

			}
			
			if (Game.Area == ACONFIG.REG) {
				int x = 0, y = 0;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 6; j++) {
						if (mx >= 325 + x && mx <= 425 + x) {
							if (my >= 10 + y && my <= 157 + y) {
								// //////////////////////////
								Game.State = Game.State.OPTIONS;
								// //////////////////////////
							}
						}
						
						x += 125;
					}
					x=0;
					y += 200;
					
					
				}

			}
			
			if (Game.Area == ACONFIG.LARGE) {
				int x = 0, y = 0;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 8; j++) {
						if (mx >= 200 + x && mx <= 300 + x) {
							if (my >= 10 + y && my <= 157 + y) {
								// //////////////////////////
								Game.State = Game.State.OPTIONS;
								// //////////////////////////
							}
						}
						
						x += 125;
					}
					x=0;
					y += 200;
					
					
				}

			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

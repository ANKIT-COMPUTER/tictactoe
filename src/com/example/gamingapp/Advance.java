package com.example.gamingapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Advance extends Activity {
	private Button ab1, ab2, ab3, ab4, ab5, ab6, ab7, ab8, ab9,aC2, aC1,aw;
	TextView atv;
	String ap1;
	String ap2;
	Boolean apTurn;
	int an = 0;
	int amatch = 0;
	int ap1win = 0;
	int ap2win = 0;
	int adraw=0;
	int aarr[][] = { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advance);
		atv = (TextView) findViewById(R.id.ATV);
		Intent intent = getIntent();
		if (amatch % 2 == 0) {
			apTurn = true;
			ap2 = intent.getStringExtra("player2");
			ap1 = intent.getStringExtra("player1");
			atv.setText(ap1 + " " + " " + "Turn");

		} else {
			apTurn = false;
			ap2 = intent.getStringExtra("player2");
			ap1 = intent.getStringExtra("player1");
			atv.setText(ap2 + " " + " " + "Turn");
		}
		aarr[0][0] = 2;
		aarr[0][1] = 2;
		aarr[0][2] = 2;
		aarr[1][0] = 2;
		aarr[1][1] = 2;
		aarr[1][2] = 2;
		aarr[2][0] = 2;
		aarr[2][1] = 2;
		aarr[2][2] = 2;
		aC1= (Button) findViewById(R.id.abutton_1);
		aC2= (Button) findViewById(R.id.abutton_2);
		assignId(ab1, R.id.A1);
		assignId(ab2, R.id.A2);
		assignId(ab3, R.id.A3);
		assignId(ab4, R.id.A4);
		assignId(ab5, R.id.A5);
		assignId(ab6, R.id.A6);
		assignId(ab7, R.id.A7);
		assignId(ab8, R.id.A8);
		assignId(ab9, R.id.A9);
		aC1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				final Dialog dialog_2 = new Dialog(Advance.this);
				dialog_2.setContentView(R.layout.report);
			
				dialog_2.setTitle("Report");
				dialog_2.show();
				
				TextView ar1 = (TextView) dialog_2.findViewById(R.id.r1tv1);
				TextView ar2 = (TextView) dialog_2.findViewById(R.id.r2tv1);
				TextView ar3 = (TextView) dialog_2.findViewById(R.id.r3tv1);
				TextView ar4 = (TextView) dialog_2.findViewById(R.id.r4tv1);
				TextView az1 = (TextView) dialog_2.findViewById(R.id.r1tv2);
				TextView az2 = (TextView) dialog_2.findViewById(R.id.r2tv2);
				TextView az3 = (TextView) dialog_2.findViewById(R.id.r3tv2);
				TextView az4 = (TextView) dialog_2.findViewById(R.id.r4tv2);
				ar1.setText("Total Match");
				ar2.setText(ap1+" "+"Won");
				ar3.setText(ap2+" "+"Won");
				ar4.setText("Draw Match");
                az1.setText("="+Integer.toString(amatch));
                az2.setText("="+Integer.toString(ap1win));
                az3.setText("="+Integer.toString(ap2win));
                az4.setText("="+Integer.toString(adraw));
			}

		});
		aC2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

			android.os.Process.killProcess(android.os.Process.myPid());
			System.exit(1);
			}

		});

	
		
	}


	void assignId(Button btn, int id) {
		btn = (Button) findViewById(id);
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Button button = (Button) view;
				
					if (apTurn) {
						button.setText("X");
						atv.setText(ap2 + " " + " " + "Turn");
						fillArr(button, 1);
					
						apTurn = false;
						try {
							check();
						} catch (Exception e) {
							toastMessage(e.getMessage());
						}

					} else {
						button.setText("O");
						atv.setText(ap1 + " " + " " + "Turn");
						fillArr(button, 0);
					
						apTurn = true;

						try {
							check();
						} catch (Exception e) {
							toastMessage(e.getMessage());
						}

					}

				
			}
		});
	}

	private void toastMessage(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	private void check() {
		// for X
		// row
		if (aarr[0][0] == 1 && aarr[0][1] == 1 && aarr[0][2] == 1) {
			Player_1_won(ap1, "You", "Won");
			ap1win++;
		}
		if (aarr[1][0] == 1 && aarr[1][1] == 1 && aarr[1][2] == 1) {
			Player_1_won(ap1, "You", "Won");
			ap1win++;
		}
		if (aarr[2][0] == 1 && aarr[2][1] == 1 && aarr[2][2] == 1) {
			Player_1_won(ap1, "You", "Won");
			ap1win++;
		}
		// column
		if (aarr[0][0] == 1 && aarr[1][0] == 1 && aarr[2][0] == 1) {
			Player_1_won(ap1, "You", "Won");
			ap1win++;
		}
		if (aarr[0][1] == 1 && aarr[1][1] == 1 && aarr[2][1] == 1) {
			Player_1_won(ap1, "You", "Won");
			ap1win++;
		}
		if (aarr[0][2] == 1 && aarr[1][2] == 1 && aarr[2][2] == 1) {
			Player_1_won(ap1, "You", "Won");
			ap1win++;
		}

		// d
		if (aarr[0][0] == 1 && aarr[1][1] == 1 && aarr[2][2] == 1) {
			Player_1_won(ap1, "You", "Won");
			ap1win++;
		}
		if (aarr[0][2] == 1 && aarr[1][1] == 1 && aarr[2][0] == 1) {
			Player_1_won(ap1, "You", "Won");
			ap1win++;
		}

		// for O
		// row
		if (aarr[0][0] == 0 && aarr[0][1] == 0 && aarr[0][2] == 0) {
			Player_1_won(ap2, "You", "Won");
			ap2win++;
		}
		if (aarr[1][0] == 0 && aarr[1][1] == 0 && aarr[1][2] == 0) {
			Player_1_won(ap2, "You", "Won");
			ap2win++;
		}
		if (aarr[2][0] == 0 && aarr[2][1] == 0 && aarr[2][2] == 0) {
			Player_1_won(ap2, "You", "Won");
			ap2win++;
		}
		// column
		if (aarr[0][0] == 0 && aarr[1][0] == 0 && aarr[2][0] == 0) {
			Player_1_won(ap2, "You", "Won");
			ap2win++;
		}
		if (aarr[0][1] == 0 && aarr[1][1] == 0 && aarr[2][1] == 0) {
			Player_1_won(ap2, "You", "Won");
			ap2win++;
		}
		if (aarr[0][2] == 0 && aarr[1][2] == 0 && aarr[2][2] == 0) {
			Player_1_won(ap2, "You", "Won");
			ap2win++;
		}

		// d
		if (aarr[0][0] == 0 && aarr[1][1] == 0 && aarr[2][2] == 0) {
			Player_1_won(ap2, "You", "Won");
			ap2win++;
		}
		if (aarr[0][2] == 0 && aarr[1][1] == 0 && aarr[2][0] == 0) {
			Player_1_won(ap2, "You", "Won");
			ap2win++;
		}
	
	}

	private void fillArr(Button btn, int value) {
		if (R.id.A1 == btn.getId()) {
			aarr[0][0] = value;

		} else if (R.id.A2 == btn.getId()) {
			aarr[0][1] = value;

		} else if (R.id.A3 == btn.getId()) {
			aarr[0][2] = value;

		} else if (R.id.A4 == btn.getId()) {
			aarr[1][0] = value;
		} else if (R.id.A5 == btn.getId()) {
			aarr[1][1] = value;
		} else if (R.id.A6 == btn.getId()) {
			aarr[1][2] = value;
		} else if (R.id.A7 == btn.getId()) {
			aarr[2][0] = value;
		} else if (R.id.A8 == btn.getId()) {
			aarr[2][1] = value;
		} else if (R.id.A9 == btn.getId()) {
			aarr[2][2] = value;
		}

	}

	private void Player_1_won(String s1, String s2, String s3) {
		amatch++;
		
		final Dialog dialog_1 = new Dialog(Advance.this);
		dialog_1.setContentView(R.layout.p1_win);
		dialog_1.setCancelable(false);
		dialog_1.setTitle("Congratulation");
		dialog_1.show();
		aw = (Button) dialog_1.findViewById(R.id.Pbutton);
		TextView t1 = (TextView) dialog_1.findViewById(R.id.dtv1);
		TextView t2 = (TextView) dialog_1.findViewById(R.id.dtv2);
		TextView t3 = (TextView) dialog_1.findViewById(R.id.dtv3);
		t1.setText(s1);
		t2.setText(s2);
		t3.setText(s3);
		aw.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				dialog_1.dismiss();
				onCreate(null);

			}

		});

	}

}

package com.example.gamingapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Classic extends Activity {
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, C1, C2, w;
	TextView tv;
	String p1;
	String p2;
	Boolean pTurn;
	int n = 0;
	int match = 0;
	int p1win = 0;
	int p2win = 0;
	int draw=0;
	int arr[][] = { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classic);
		tv = (TextView) findViewById(R.id.CTV);
		Intent intent = getIntent();
		if (match % 2 == 0) {
			pTurn = true;
			p2 = intent.getStringExtra("player2");
			p1 = intent.getStringExtra("player1");
			tv.setText(p1 + " " + " " + "Turn");

		} else {
			pTurn = false;
			p2 = intent.getStringExtra("player2");
			p1 = intent.getStringExtra("player1");
			tv.setText(p2 + " " + " " + "Turn");
		}
		arr[0][0] = 2;
		arr[0][1] = 2;
		arr[0][2] = 2;
		arr[1][0] = 2;
		arr[1][1] = 2;
		arr[1][2] = 2;
		arr[2][0] = 2;
		arr[2][1] = 2;
		arr[2][2] = 2;
		C1= (Button) findViewById(R.id.cbutton_1);
		C2= (Button) findViewById(R.id.cbutton_2);
		assignId(b1, R.id.B1);
		assignId(b2, R.id.B2);
		assignId(b3, R.id.B3);
		assignId(b4, R.id.B4);
		assignId(b5, R.id.B5);
		assignId(b6, R.id.B6);
		assignId(b7, R.id.B7);
		assignId(b8, R.id.B8);
		assignId(b9, R.id.B9);
		C1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				final Dialog dialog_2 = new Dialog(Classic.this);
				dialog_2.setContentView(R.layout.report);
			
				dialog_2.setTitle("Report");
				dialog_2.show();
				
				TextView r1 = (TextView) dialog_2.findViewById(R.id.r1tv1);
				TextView r2 = (TextView) dialog_2.findViewById(R.id.r2tv1);
				TextView r3 = (TextView) dialog_2.findViewById(R.id.r3tv1);
				TextView r4 = (TextView) dialog_2.findViewById(R.id.r4tv1);
				TextView z1 = (TextView) dialog_2.findViewById(R.id.r1tv2);
				TextView z2 = (TextView) dialog_2.findViewById(R.id.r2tv2);
				TextView z3 = (TextView) dialog_2.findViewById(R.id.r3tv2);
				TextView z4 = (TextView) dialog_2.findViewById(R.id.r4tv2);
				r1.setText("Total Match");
				r2.setText(p1+" "+"Won");
				r3.setText(p2+" "+"Won");
				r4.setText("Draw Match");
                z1.setText("="+Integer.toString(match));
                z2.setText("="+Integer.toString(p1win));
                z3.setText("="+Integer.toString(p2win));
                z4.setText("="+Integer.toString(draw));
			}

		});
		C2.setOnClickListener(new View.OnClickListener() {
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
				if (button.getText() == "") {
					if (pTurn) {
						button.setText("X");
						tv.setText(p2 + " " + " " + "Turn");
						fillArr(button, 1);
						n++;
						pTurn = false;
						try {
							check();
						} catch (Exception e) {
							toastMessage(e.getMessage());
						}

					} else {
						button.setText("O");
						tv.setText(p1 + " " + " " + "Turn");
						fillArr(button, 0);
						n++;
						pTurn = true;

						try {
							check();
						} catch (Exception e) {
							toastMessage(e.getMessage());
						}

					}

				} else {
					toastMessage("Alread Choosed");
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
		if (arr[0][0] == 1 && arr[0][1] == 1 && arr[0][2] == 1) {
			Player_1_won(p1, "You", "Won");
			p1win++;
		}
		if (arr[1][0] == 1 && arr[1][1] == 1 && arr[1][2] == 1) {
			Player_1_won(p1, "You", "Won");
			p1win++;
		}
		if (arr[2][0] == 1 && arr[2][1] == 1 && arr[2][2] == 1) {
			Player_1_won(p1, "You", "Won");
			p1win++;
		}
		// column
		if (arr[0][0] == 1 && arr[1][0] == 1 && arr[2][0] == 1) {
			Player_1_won(p1, "You", "Won");
			p1win++;
		}
		if (arr[0][1] == 1 && arr[1][1] == 1 && arr[2][1] == 1) {
			Player_1_won(p1, "You", "Won");
			p1win++;
		}
		if (arr[0][2] == 1 && arr[1][2] == 1 && arr[2][2] == 1) {
			Player_1_won(p1, "You", "Won");
			p1win++;
		}

		// d
		if (arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) {
			Player_1_won(p1, "You", "Won");
			p1win++;
		}
		if (arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1) {
			Player_1_won(p1, "You", "Won");
			p1win++;
		}

		// for O
		// row
		if (arr[0][0] == 0 && arr[0][1] == 0 && arr[0][2] == 0) {
			Player_1_won(p2, "You", "Won");
			p2win++;
		}
		if (arr[1][0] == 0 && arr[1][1] == 0 && arr[1][2] == 0) {
			Player_1_won(p2, "You", "Won");
			p2win++;
		}
		if (arr[2][0] == 0 && arr[2][1] == 0 && arr[2][2] == 0) {
			Player_1_won(p2, "You", "Won");
			p2win++;
		}
		// column
		if (arr[0][0] == 0 && arr[1][0] == 0 && arr[2][0] == 0) {
			Player_1_won(p2, "You", "Won");
			p2win++;
		}
		if (arr[0][1] == 0 && arr[1][1] == 0 && arr[2][1] == 0) {
			Player_1_won(p2, "You", "Won");
			p2win++;
		}
		if (arr[0][2] == 0 && arr[1][2] == 0 && arr[2][2] == 0) {
			Player_1_won(p2, "You", "Won");
			p2win++;
		}

		// d
		if (arr[0][0] == 0 && arr[1][1] == 0 && arr[2][2] == 0) {
			Player_1_won(p2, "You", "Won");
			p2win++;
		}
		if (arr[0][2] == 0 && arr[1][1] == 0 && arr[2][0] == 0) {
			Player_1_won(p2, "You", "Won");
			p2win++;
		}
		if (n == 9) {
			Player_1_won("Draw", "Try", "Again");
			draw++;
		}
	}

	private void fillArr(Button btn, int value) {
		if (R.id.B1 == btn.getId()) {
			arr[0][0] = value;

		} else if (R.id.B2 == btn.getId()) {
			arr[0][1] = value;

		} else if (R.id.B3 == btn.getId()) {
			arr[0][2] = value;

		} else if (R.id.B4 == btn.getId()) {
			arr[1][0] = value;
		} else if (R.id.B5 == btn.getId()) {
			arr[1][1] = value;
		} else if (R.id.B6 == btn.getId()) {
			arr[1][2] = value;
		} else if (R.id.B7 == btn.getId()) {
			arr[2][0] = value;
		} else if (R.id.B8 == btn.getId()) {
			arr[2][1] = value;
		} else if (R.id.B9 == btn.getId()) {
			arr[2][2] = value;
		}

	}

	private void Player_1_won(String s1, String s2, String s3) {
		match++;
		n = 0;
		final Dialog dialog_1 = new Dialog(Classic.this);
		dialog_1.setContentView(R.layout.p1_win);
		dialog_1.setCancelable(false);
		dialog_1.setTitle("Congratulation");
		dialog_1.show();
		w = (Button) dialog_1.findViewById(R.id.Pbutton);
		TextView t1 = (TextView) dialog_1.findViewById(R.id.dtv1);
		TextView t2 = (TextView) dialog_1.findViewById(R.id.dtv2);
		TextView t3 = (TextView) dialog_1.findViewById(R.id.dtv3);
		t1.setText(s1);
		t2.setText(s2);
		t3.setText(s3);
		w.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				dialog_1.dismiss();
				onCreate(null);

			}

		});

	}
}

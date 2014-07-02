package com.example.alertdialog;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private Button btnAltDlg, btnAltDlgBud;

		public PlaceholderFragment() {
		}

		
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

			btnAltDlg = (Button) rootView
					.findViewById(R.id.btnAlertDialog);
			
			btnAltDlgBud = (Button) rootView
					.findViewById(R.id.btnAlertDialogBuilder);

			btnAltDlgBud.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					AlertDialog.Builder altDlgBldr = new AlertDialog.Builder(
							getActivity());
					altDlgBldr.setTitle("AlertDialog");
					altDlgBldr.setMessage("AlertDialog 範例");
					altDlgBldr.setIcon(android.R.drawable.ic_dialog_info);
					altDlgBldr.setCancelable(false);

					altDlgBldr.setNegativeButton("否",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub

									Toast.makeText(getActivity(), "你按了\"否\"", Toast.LENGTH_SHORT).show();
									
								}
							});

					altDlgBldr.setNeutralButton("取消",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub

									Toast.makeText(getActivity(), "你按了\"取消\"", Toast.LENGTH_SHORT).show();
								}
							});

					altDlgBldr.setPositiveButton("是",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									Toast.makeText(getActivity(), "你按了\"是\"", Toast.LENGTH_SHORT).show();
								}
							});

					altDlgBldr.show();

				}
			});
			
			btnAltDlg.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					MyAlertDialog myAltDlg = new MyAlertDialog(getActivity());
					myAltDlg.setTitle("myAltDlog");
					myAltDlg.setMessage("使用 MyAlertDialog 產生");
					myAltDlg.setIcon(android.R.drawable.ic_dialog_info);
					myAltDlg.setCancelable(true);
					myAltDlg.show();
				}
			});

			return rootView;
		}
	}

}

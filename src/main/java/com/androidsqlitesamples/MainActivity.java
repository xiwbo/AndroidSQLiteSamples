package com.androidsqlitesamples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Toast;
import android.text.InputType;

public class MainActivity extends Activity
{
	DatabaseAdapter adapter;
	private EditText id,fname,lname,age;
	private Button add,update,delete, viewAll;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(getApplicationContext());
		id = new EditText(getApplicationContext());
		fname = new EditText(getApplicationContext());
		lname = new EditText(getApplicationContext());
		age = new EditText(getApplicationContext());
		add = new Button(getApplicationContext());
		update = new Button(getApplicationContext());
		delete = new Button(getApplicationContext());
		viewAll = new Button(getApplicationContext());
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		ViewGroup.LayoutParams childLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		layout.setLayoutParams(layoutParams);
		layout.setOrientation(LinearLayout.VERTICAL);
		id.setLayoutParams(childLayoutParams);
		fname.setLayoutParams(childLayoutParams);
		lname.setLayoutParams(childLayoutParams);
		age.setLayoutParams(childLayoutParams);
		add.setLayoutParams(childLayoutParams);
		update.setLayoutParams(childLayoutParams);
		delete.setLayoutParams(childLayoutParams);
		viewAll.setLayoutParams(childLayoutParams);
		id.setInputType(InputType.TYPE_CLASS_NUMBER);
		fname.setInputType(InputType.TYPE_CLASS_TEXT);
		lname.setInputType(InputType.TYPE_CLASS_TEXT);
		age.setInputType(InputType.TYPE_CLASS_NUMBER);
		id.setHint("ID");
		fname.setHint("First name");
		lname.setHint("Last name");
		age.setHint("Age");
		add.setText("ADD");
		update.setText("UPDATE");
		delete.setText("DELETE");
		viewAll.setText("VIEW ALL");
		layout.addView(id);
		layout.addView(fname);
		layout.addView(lname);
		layout.addView(age);
		layout.addView(add);
		layout.addView(update);
		layout.addView(delete);
		layout.addView(viewAll);
		add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "ADD BUTTON", Toast.LENGTH_SHORT).show();
			}
		});
		update.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "update BUTTON", Toast.LENGTH_SHORT).show();
			}
		});
		delete.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Delete BUTTON", Toast.LENGTH_SHORT).show();
			}
		});
		viewAll.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "view all BUTTON", Toast.LENGTH_SHORT).show();
			}
		});
		setContentView(layout);
		adapter = new DatabaseAdapter(this);
	}
}

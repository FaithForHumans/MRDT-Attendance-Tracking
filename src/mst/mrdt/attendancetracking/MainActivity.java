package mst.mrdt.attendancetracking;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {

  private NfcAdapter nfcAdapter;
  //private PendingIntent pendingIntent;
  TextView tempView;
  
  private AlertDialog alertDialog;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    alertDialog = new AlertDialog.Builder(this).setNeutralButton("OK",
        null).create();
    
    tempView = (TextView) findViewById(R.id.textView1);
    
    nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    if ( nfcAdapter == null ) {
      alertDialog.setTitle(R.string.error);
      alertDialog.setMessage(getText(R.string.noNfc));
      alertDialog.show();
      finish();
      return;
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
  
  @Override
  public void onResume() {
    super.onResume();
/*
    if( nfcAdapter != null ) { //check if there's no NFC
      if( !nfcAdapter.isEnabled() ) {
        //builder for dialog  box to enable NFC
        AlertDialog.Builder nfcDialogDisabled = new AlertDialog.Builder(this);
        
        //set the dialog box message
        nfcDialogDisabled.setMessage(R.string.nfcDisabled);
        
        //set the okay button to open wireless settings so user can enable NFC
        nfcDialogDisabled.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
          @SuppressLint("InlinedApi") //suppressing for ACTION_NFC_SETTINGS
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            if (android.os.Build.VERSION.SDK_INT >= 16) {
              startActivity(new Intent(android.provider.Settings.ACTION_NFC_SETTINGS));
            }
            else {
              startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
            }
          }
        });
        
        //set the cancel button to close the program
        nfcDialogDisabled.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            finish();
          }
        });
        
        //show the dialog box
        nfcDialogDisabled.create().show();
      }
      
      String currentAction = getIntent().getAction();
      if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(currentAction)  ||
          NfcAdapter.ACTION_TECH_DISCOVERED.equals(currentAction) ||
          NfcAdapter.ACTION_NDEF_DISCOVERED.equals(currentAction) ) {
        
        //get the read tag id
        byte[] tagId = ((Tag) (getIntent().getParcelableExtra(NfcAdapter.EXTRA_TAG))).getId();
        
        //covert the read id to a hex format
        StringBuilder hexBuilder = new StringBuilder();
        for(int s = tagId.length - 1; s >= 0; s-- ) {
          //convert it to a temporary integer with only 16 bits
          int temp = tagId[s] & 0xff;
          //make sure a zero gets entered for any number less than ten
          if ( temp < 0x10 ) {
            hexBuilder.append('0');
          }
          //append the number to the end of the string
          hexBuilder.append(Integer.toHexString(temp));
          //enter a space between pairs
          if (s > 0) {
            hexBuilder.append(" ");
          }
        }
        
        tempView.setText(hexBuilder.toString());
      }
    }
    */
  }
}

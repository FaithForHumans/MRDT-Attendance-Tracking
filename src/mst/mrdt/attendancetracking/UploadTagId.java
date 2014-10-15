package mst.mrdt.attendancetracking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class UploadTagId extends Activity {
  public static final String IS_ACTIVE = "EXTRA_UPLOAD_ONSCREEN";
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.attendance_uploader);
  }
  
  @Override
  protected void onPause() {
    super.onPause();
    Intent passIntent = new Intent(getBaseContext(), MainActivity.class);
    passIntent.putExtra(IS_ACTIVE ,false);
    startActivity(passIntent);
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    Intent passIntent = new Intent(getBaseContext(), MainActivity.class);
    passIntent.putExtra(IS_ACTIVE,true);
    startActivity(passIntent);
  }
}

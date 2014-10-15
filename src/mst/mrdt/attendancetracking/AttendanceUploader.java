package mst.mrdt.attendancetracking;

import android.app.Activity;
import android.content.Intent;

public class AttendanceUploader extends Activity {
  
  public static final String IS_ACTIVE = "EXTRA_ATTENDANCE_ONSCREEN";
  
  @Override
  protected void onPause() {
    super.onPause();
    Intent passIntent = new Intent(this, MainActivity.class);
    passIntent.putExtra(IS_ACTIVE ,false);
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    Intent passIntent = new Intent(this, MainActivity.class);
    passIntent.putExtra(IS_ACTIVE,true);
    startActivity(passIntent);
  }
}

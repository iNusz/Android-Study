# Relative , Linear, Grid Layout

###### MainActivity.java

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        //1. 위젯 변수를 선언

    Button btnRelative, btnLinear, btnGrid, btnSpinner;

// TODO 를 이용하면 항상 커밋할때도 물어보고 이렇게 눈에 잘띄어서 좋다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2.

        btnRelative = (Button) findViewById(R.id.btnRelative);
        btnLinear = (Button) findViewById(R.id.btnLinear);
        btnGrid = (Button) findViewById(R.id.btnGrid);
        btnSpinner = (Button) findViewById(R.id.btnSpinner);

        btnRelative.setOnClickListener(this);
        btnLinear.setOnClickListener(this);
        btnGrid.setOnClickListener(this);
        btnSpinner.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRelative:
                Intent intent = new Intent(this, RelativeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLinear:
                Intent intent1 = new Intent(this, LinearActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnGrid:
                Intent intent2 = new Intent(this, GridActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnSpinner:
                break;
        }
    }
}

```





###### RelativeActivity.java

```java
public class RelativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
    }
}

```





###### LinearActivity.java

```java
public class LinearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
    }
}

```





###### GridActivity.java

```java
public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }
}

```



###### activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.seunghoshin.android.basiclayout.MainActivity">

    <Button
        android:id="@+id/btnRelative"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="16dp"
        android:layout_marginStart="16dp"
        android:text="Relative Layout"
        app:layout_constraintLeft_toLeftOf="parent"
        tools:layout_editor_absoluteY="48dp" />

    <Button
        android:id="@+id/btnLinear"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Linear Layout"
        app:layout_constraintLeft_toLeftOf="@+id/btnRelative"
        app:layout_constraintTop_toBottomOf="@+id/btnRelative" />

    <Button
        android:id="@+id/btnGrid"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="0dp"
        android:layout_marginTop="0dp"
        android:text="Grid Layout"
        app:layout_constraintLeft_toLeftOf="@+id/btnLinear"
        app:layout_constraintTop_toBottomOf="@+id/btnLinear" />

    <Button
        android:id="@+id/btnSpinner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Spinner"
        app:layout_constraintLeft_toLeftOf="@+id/btnGrid"
        app:layout_constraintTop_toBottomOf="@+id/btnGrid" />

</android.support.constraint.ConstraintLayout>

```



###### activity_relative.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.seunghoshin.android.basiclayout.RelativeActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Relative Activity"
        android:layout_marginLeft="31dp"
        android:layout_marginStart="31dp"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_marginTop="67dp" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:layout_below="@+id/textView"
        android:layout_alignLeft="@+id/textView"
        android:layout_alignStart="@+id/textView"
        android:layout_marginTop="43dp" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="37dp"
        android:text="Button"
        android:layout_below="@+id/button"
        android:layout_alignLeft="@+id/button"
        android:layout_alignStart="@+id/button" />
</RelativeLayout>

```



###### activity_linear.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    tools:context="com.seunghoshin.android.basiclayout.LinearActivity">

    <Button
        android:id="@+id/button11"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="Button" />

    <Button
        android:id="@+id/button12"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="Button" />

    <Button
        android:id="@+id/button15"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="2"
        android:text="Button" />
</LinearLayout>

```



###### activity_grid.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<GridLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:columnCount="3"
    tools:context="com.seunghoshin.android.basiclayout.GridActivity">

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_columnSpan="2"
        android:layout_columnWeight="1"
        android:text="Button" />


    <Button
        android:id="@+id/button4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button" />

    <Button
        android:id="@+id/button5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button" />

    <Button
        android:id="@+id/button6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button" />

    <Button
        android:id="@+id/button7"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button" />

    <Button
        android:id="@+id/button13"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button" />
</GridLayout>

```



### Android Emulator

![BasicLayout.jpg](https://github.com/iNusz/Android-Study/blob/master/Android%20image/BasicLayout.jpg)
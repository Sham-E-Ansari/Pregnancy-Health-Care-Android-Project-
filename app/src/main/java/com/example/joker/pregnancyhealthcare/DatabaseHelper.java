package com.example.joker.pregnancyhealthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

/**
 * Created by Joker on 19-May-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private  int id;
    private static final String DATABASE_NAME = "user_list.db";
    private static final String TABLE_NAME = "User_Info";
    private static final String TABLE_WEIGHT = "Weight_Info";
    private static final String TABLE_DOCTOR = "Doctor_info";
    private static final String TABLE_POST = "Post_info";
    private static final String TABLE_COMMENT = "Comment_info";
    private static final String TABLE_NUTRITION = "Nutrition_info";



    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_MOBILE = "Mobile";
    private static final String COLUMN_EMOBILE1 = "EMobile1";
    private static final String COLUMN_EMOBILE2 = "EMobile2";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_BLOODGROUP = "BloodGroup";
    private static final String COLUMN_BDAY = "Birthday";
    private static final String COLUMN_HEIGHT = "Height";
    private static final String COLUMN_WEIGHT = "Weight";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_LOCATION = "Location";
    private static final String COLUMN_PLASTYEAR = "PLastYear";
    private static final String COLUMN_PLASTMONTH = "PLastMonth";
    private static final String COLUMN_PLASTDAY = "PLastDay";




    private static final String COLUMN_WID = "WID";
    private static final String COLUMN_CAT = "Category";
    private static final String COLUMN_WEEK = "Week";
    private static final String COLUMN_BGAIN = "B_Gain";
    private static final String COLUMN_AGAIN = "A_Gain";

    private static final String COLUMN_DOCID = "DOC_ID";
    private static final String COLUMN_DOCNAME = "DOCName";
    private static final String COLUMN_DOCMOBILE = "DOCMobile";
    private static final String COLUMN_DOCEMAIL = "DOCemail";
    private static final String COLUMN_DOCPASS = "DOCpass";

    private static final String COLUMN_POSTID = "POST_ID";
    private static final String COLUMN_POSTTOPIC = "PTopic";
    private static final String COLUMN_POST = "PPost";
    private static final String COLUMN_USER = "PUser";

    private static final String COLUMN_COMMENTID = "C_ID";
    private static final String COLUMN_CPOSTID = "CP_ID";
    private static final String COLUMN_COMMENT = "cComment";
    private static final String COLUMN_CUSER = "CUser";

    private static final String COLUMN_NUTID = "N_ID";
    private static final String COLUMN_NUTRIM = "nTrim";
    private static final String COLUMN_NAGE = "nAge";
    private static final String COLUMN_NWEIGHT = "nWeight";
    private static final String COLUMN_NWEEK = "nWeek";
    private static final String COLUMN_NCAL = "nCal";



    SQLiteDatabase sqLiteDatabase;

    //Query
    private static final String TABLE_CREATE_NUTRITION = "create table "+TABLE_NUTRITION+"("+COLUMN_NUTID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_NUTRIM+
            " integer,"+ COLUMN_NAGE+" integer,"+ COLUMN_NWEEK+" integer,"+ COLUMN_NWEIGHT+" integer,"+COLUMN_NCAL +" integer);";

    private static final String TABLE_CREATE = "create table "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_NAME+
            " text,"+COLUMN_MOBILE+" text,"+COLUMN_EMOBILE1+" text,"+COLUMN_EMOBILE2+" text,"+COLUMN_EMAIL+" text,"+COLUMN_PASSWORD+" text,"+COLUMN_BLOODGROUP+" text,"+
            COLUMN_BDAY+" text,"+COLUMN_HEIGHT+" text,"+
            COLUMN_WEIGHT+" text,"+COLUMN_LOCATION+" text,"+COLUMN_PLASTYEAR+" INTEGER,"+COLUMN_PLASTMONTH+" INTEGER,"+COLUMN_PLASTDAY+" INTEGER);";

    private static final String TABLE_CREATE_WEIGHT = "create table "+TABLE_WEIGHT+"("+COLUMN_WID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_CAT+
            " text,"+ COLUMN_WEEK +" text,"+COLUMN_BGAIN+" text,"+COLUMN_AGAIN+" text);";

    private static final String TABLE_CREATE_DOCTOR = "create table "+TABLE_DOCTOR+"("+COLUMN_DOCID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_DOCNAME+
            " text,"+ COLUMN_DOCMOBILE +" text,"+COLUMN_DOCEMAIL+" text,"+COLUMN_DOCPASS+" text);";

    private static final String TABLE_CREATE_POST = "create table "+TABLE_POST+"("+COLUMN_POSTID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_POSTTOPIC+
            " text,"+ COLUMN_POST +" text,"+COLUMN_USER+" text);";

    private static final String TABLE_CREATE_COMMENT = "create table "+TABLE_COMMENT+"("+COLUMN_COMMENTID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_CPOSTID+
            " integer,"+ COLUMN_COMMENT+" text,"+COLUMN_CUSER +" text);";





    public DatabaseHelper(Context context) //Constructor
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE); //Execute Query
        sqLiteDatabase.execSQL(TABLE_CREATE_WEIGHT);
        sqLiteDatabase.execSQL(TABLE_CREATE_DOCTOR);
        sqLiteDatabase.execSQL(TABLE_CREATE_POST);
        sqLiteDatabase.execSQL(TABLE_CREATE_COMMENT);
        sqLiteDatabase.execSQL(TABLE_CREATE_NUTRITION);

        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(query);

        String query2 = "DROP TABLE IF EXISTS "+TABLE_COMMENT;
        sqLiteDatabase.execSQL(query2);

        String query3 = "DROP TABLE IF EXISTS "+TABLE_WEIGHT;
        sqLiteDatabase.execSQL(query3);

        String query4 = "DROP TABLE IF EXISTS "+TABLE_DOCTOR;
        sqLiteDatabase.execSQL(query4);

        String query5 = "DROP TABLE IF EXISTS "+TABLE_POST;
        sqLiteDatabase.execSQL(query5);

        String query6 = "DROP TABLE IF EXISTS "+TABLE_NUTRITION;
        sqLiteDatabase.execSQL(query6);

        this.onCreate(sqLiteDatabase);
    }

    public  void insertUser(User c)
    {
        //to insert anything in database it needs to make writeable
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getuName());
        values.put(COLUMN_MOBILE,c.getuMob());
        values.put(COLUMN_PASSWORD,c.getuPass());
        values.put(COLUMN_EMAIL,c.getuEmail());
        values.put(COLUMN_BDAY,c.getuDob());
        values.put(COLUMN_BLOODGROUP,c.getuBld());
        values.put(COLUMN_EMOBILE1,c.getuEmob1());
        values.put(COLUMN_EMOBILE2,c.getuEmob2());
        values.put(COLUMN_PLASTYEAR,c.getYear());
        values.put(COLUMN_PLASTMONTH,c.getMonth());
        values.put(COLUMN_PLASTDAY,c.getDay());
        values.put(COLUMN_HEIGHT,c.getuHeight());
        values.put(COLUMN_WEIGHT,c.getuWeight());
        //values.put(COLUMN_EXDATE,c.getDate());
        values.put(COLUMN_LOCATION,c.getuLoc());

        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();
    }
    public  void insertQuestion(Question q)
    {
        //to insert anything in database it needs to make writeable
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_POSTTOPIC,q.getPostTopic());
        values.put(COLUMN_POST,q.getPost());
        values.put(COLUMN_USER,q.getPostUser());

        sqLiteDatabase.insert(TABLE_POST,null,values);
        sqLiteDatabase.close();
    }
    public  void insertComment(Comment c)
    {
        //to insert anything in database it needs to make writeable
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CPOSTID,c.getPostId());
        values.put(COLUMN_COMMENT,c.getComment());
        values.put(COLUMN_CUSER,c.getCommentUser());

        sqLiteDatabase.insert(TABLE_COMMENT,null,values);
        sqLiteDatabase.close();
    }

    public void updateUser(User c,int ID)
    {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getuName());
        values.put(COLUMN_MOBILE,c.getuMob());
        values.put(COLUMN_PASSWORD,c.getuPass());
        values.put(COLUMN_EMAIL,c.getuEmail());
        values.put(COLUMN_BDAY,c.getuDob());
        values.put(COLUMN_BLOODGROUP,c.getuBld());
        values.put(COLUMN_EMOBILE1,c.getuEmob1());
        values.put(COLUMN_EMOBILE2,c.getuEmob2());
        values.put(COLUMN_HEIGHT,c.getuHeight());
        values.put(COLUMN_WEIGHT,c.getuWeight());
        values.put(COLUMN_LOCATION,c.getuLoc());
        values.put(COLUMN_PLASTYEAR,c.getYear());
        values.put(COLUMN_PLASTMONTH,c.getMonth());
        values.put(COLUMN_PLASTDAY,c.getDay());

        sqLiteDatabase.update(TABLE_NAME,values,"ID="+ID,null);
        sqLiteDatabase.close();
    }
    public void updateDoctor(Doctor d,int ID)
    {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DOCNAME,d.getdName());
        values.put(COLUMN_DOCMOBILE,d.getdMob());
        values.put(COLUMN_DOCPASS,d.getdPass());
        sqLiteDatabase.update(TABLE_DOCTOR,values,"ID="+ID,null);
        sqLiteDatabase.close();
    }


    public  String searchPassword(String givenEmail)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT Email, Password, ID FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        String storeEmail,storePass;
        storePass = "Not Found";
        if(cursor.moveToFirst())
        {
            do
            {
                storeEmail = cursor.getString(cursor.getColumnIndex("Email"));
                if(storeEmail.equals(givenEmail))
                {
                    storePass = cursor.getString(cursor.getColumnIndex("Password"));
                    id = cursor.getInt(cursor.getColumnIndex("ID"));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return storePass;
    }

    public  String searchDocPassword(String givenEmail)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT DOCemail, DOCpass, DOC_ID FROM "+TABLE_DOCTOR;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        String storeEmail,storePass;
        storePass = "Not Found";
        if(cursor.moveToFirst())
        {
            do
            {
                storeEmail = cursor.getString(cursor.getColumnIndex("DOCemail"));
                if(storeEmail.equals(givenEmail))
                {
                    storePass = cursor.getString(cursor.getColumnIndex("DOCpass"));
                    id = cursor.getInt(cursor.getColumnIndex("DOC_ID"));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return storePass;
    }


    public int getID()
    {
        return id;
    }

    public ArrayList<String> userInfo(int givenID)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        ArrayList<String>info = new ArrayList<String>();
        int storeID;
        if(cursor.moveToFirst())
        {
            do
            {
                storeID = cursor.getInt(cursor.getColumnIndex("ID"));
                if(storeID==givenID)
                {
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_MOBILE)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_BDAY)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_BLOODGROUP)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_EMOBILE1)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_EMOBILE2)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_HEIGHT)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_WEIGHT)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_PLASTYEAR)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_PLASTMONTH)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_PLASTDAY)));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return info;
    }

    public ArrayList<String> userName(int givenID)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        ArrayList<String>info = new ArrayList<String>();
        int storeID;
        if(cursor.moveToFirst())
        {
            do
            {
                storeID = cursor.getInt(cursor.getColumnIndex("ID"));
                if(storeID==givenID)
                {
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return info;
    }




    public ArrayList<String> docInfo(int givenID)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_DOCTOR;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        ArrayList<String>info = new ArrayList<String>();
        int storeID;
        if(cursor.moveToFirst())
        {
            do
            {
                storeID = cursor.getInt(cursor.getColumnIndex("DOC_ID"));
                if(storeID==givenID)
                {
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_DOCNAME)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_DOCEMAIL)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_DOCMOBILE)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_DOCPASS)));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return info;
    }
    public int nutInfo(int a, int t, int w,int we)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NUTRITION;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        int nage, nweek,ntrim, nweight;
        int result =0;
        if(cursor.moveToFirst())
        {
            do
            {
                nage = cursor.getInt(cursor.getColumnIndex("nAge"));
                nweek = cursor.getInt(cursor.getColumnIndex("nWeek"));
                ntrim = cursor.getInt(cursor.getColumnIndex("nTrim"));
                nweight = cursor.getInt(cursor.getColumnIndex("nWeight"));
                if(nage==a && nweek== w && ntrim==t && nweight==we)
                {
                    result = cursor.getInt(cursor.getColumnIndex("nCal"));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return result;
    }

    public List<Comment> getCommentList(int PostID) {
        int pid = PostID;
        Comment comment = null;
        List<Comment> com = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Comment_info", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int pidd = cursor.getInt(1);

            if(pid==pidd) {
                comment = new Comment(cursor.getInt(0),cursor.getInt(1), cursor.getString(2), cursor.getString(3));
                com.add(comment);
            }
            cursor.moveToNext();
        }
        cursor.close();
        return com;
    }





    public List<Question> geQuestionList() {
        Question question = null;
        List<Question> ques = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Post_info", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            question = new Question(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
            ques.add(question);
            cursor.moveToNext();
        }
        cursor.close();
        return ques;
    }

    public List<Question> gesearchedQuestionList(String topic) {
        Question question = null;
        List<Question> ques = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();

        String sTopic = topic.toUpperCase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Post_info", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String sTopicc = cursor.getString(1).toUpperCase();

            if(sTopic.equals(sTopicc)) {
                question = new Question(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3));

                ques.add(question);
            }
            cursor.moveToNext();
        }
        cursor.close();
        return ques;
    }

    public  void insertWeight(Weight w)
    {
        //to insert anything in database it needs to make writeable
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CAT,w.getCat());
        values.put(COLUMN_WEEK,w.getWeek());
        values.put(COLUMN_AGAIN,w.getAgain());
        values.put(COLUMN_BGAIN,w.getBgain());

        sqLiteDatabase.insert(TABLE_WEIGHT,null,values);
        sqLiteDatabase.close();
    }
    public  float getUserheight(int givenID)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT ID, Height FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        float uHeight= 0;
        int idh;

        if(cursor.moveToFirst())
        {
            do
            {
                idh = cursor.getInt(cursor.getColumnIndex("ID"));
                if(idh == givenID)
                {
                    uHeight = Float.parseFloat(cursor.getString(cursor.getColumnIndex("Height")));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return uHeight;
    }
    public  float getUserWeight(int givenID)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT ID, Weight FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        float uWeight= 0;
        int idh;

        if(cursor.moveToFirst())
        {
            do
            {
                idh = cursor.getInt(cursor.getColumnIndex("ID"));
                if(idh == givenID)
                {
                    uWeight = Float.parseFloat(cursor.getString(cursor.getColumnIndex("Weight")));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return uWeight;
    }
    public float getBgain(String givenCat , int givenWeek)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT Category, B_Gain FROM "+TABLE_WEIGHT;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        float sBgain= 0;
        String cat;
        int week ;
        if(cursor.moveToFirst())
        {
            do
            {
                cat = cursor.getString(cursor.getColumnIndex("Category"));
                week = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Week")));
                if(cat.equals(givenCat) && givenWeek>=week )
                {
                    sBgain = sBgain + Float.parseFloat(cursor.getString(cursor.getColumnIndex("B_Gain")));

                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return sBgain;
    }
    public float getAgain(String givenCat , int givenWeek)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT Category, A_Gain FROM "+TABLE_WEIGHT;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        float again= 0;
        String cat;
        int week ;
        if(cursor.moveToFirst())
        {
            do
            {
                cat = cursor.getString(cursor.getColumnIndex("Category"));
                week = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Week")));
                if(cat.equals(givenCat) && givenWeek>=week )
                {
                    again = again + Float.parseFloat(cursor.getString(cursor.getColumnIndex("A_Gain")));

                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return again;
    }
    public  String getEphone1(int givenID)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT ID, EMobile1 FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        String phn = "Null";
        int idh;

        if(cursor.moveToFirst())
        {
            do
            {
                idh = cursor.getInt(cursor.getColumnIndex("ID"));
                if(idh == givenID)
                {
                    phn = cursor.getString(cursor.getColumnIndex("EMobile1"));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return phn;
    }
    public  String getEphone2(int givenID)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT ID, EMobile2 FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        String phn = "Null";
        int idh;

        if(cursor.moveToFirst())
        {
            do
            {
                idh = cursor.getInt(cursor.getColumnIndex("ID"));
                if(idh == givenID)
                {
                    phn = cursor.getString(cursor.getColumnIndex("EMobile2"));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return phn;
    }
}

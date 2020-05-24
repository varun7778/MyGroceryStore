package com.varun.VaSaNi.sample.mail;

import android.os.AsyncTask;
import android.util.Log;


public class LongOperation extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        try {

//            GMailSender sender = new GMailSender("sender.sendermail.com", "senders password");
//            sender.sendMail("subject",
//                    "body",
//                    "sender.sendermail.com",
//                    "reciepients.recepientmail.com");
//
            GMailSender sender = new GMailSender("varunsakshamneha@gmail.com", "gupta123");
            sender.sendMail("Registration",
                    "This is to tell you that you are registered to VaSaNi from now and your" +
                            " USERNAME:     " +
                            "PASSWORD:       ","varunsakshamneha@gmail.com",
                    "svarunanusheel@gmail.com")                   ;

        } catch (Exception e) {
            Log.e("error", e.getMessage(), e);
            return "Email Not Sent";
        }
        return "Email Sent";
    }

    @Override
    protected void onPostExecute(String result) {

        Log.e("LongOperation",result+"");
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}

# CodeVolley v1.0
Android Studio - Volley kütüphanesi için basitleştirilmiş GET ve POST işlemleri.

Volley Kütüphanesini Projeye Ekleme -> <b>build.gradle</b> içerisine

<pre>
dependencies {
  ...
  implementation 'com.android.volley:volley:1.1.1'
}
</pre>

CodeVolley kullanımı için gerekli izinler -> <b>AndroidManifest.xml</b> içerisine

<pre>
uses-permission android:name='android.permission.INTERNET'
</pre>

<h2>CodeVolley Kullanımı</h2>

Sınıfı Oluşturma -> <b>MainActivity.java</b> içerisine

<pre>
CodeVolley CDN = new CodeVolley(getApplicationContext());
</pre>

<b>AddValue</b>(key,value) Kullanımı -> <b>MainActivity.java</b> içerisine
<pre>
CDN.AddValue("username","sonradersin");
</pre>
AddValue fonksiyonu sayesinde POST veya GET işlemlerinize parametreler ekleyebilirsiniz. 1.değer parametrenin adını belirler, 2.değer parametrenin değerini belirler.

<b>Request</b>(METHOD,URL,PARAMS,CALLBACK) Kullanımı -> <b>MainActivity.java</b> içerisine
<pre>
CDN.Request(Request.Method.GET, "HTTP OR HTTPS URL", CDN.getPARAMS(), new CVCallback() {
  @Override
  public void onSuccess(String response) {
    Log.v("RESPONSE",response);
  }
});
</pre>


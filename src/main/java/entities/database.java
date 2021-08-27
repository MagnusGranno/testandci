package entities;

public class database
{
    private String USER;
    private String PW;
    private String URL;

    public database(String USER, String PW, String URL)
    {
        this.USER = USER;
        this.PW = PW;
        this.URL = URL;
    }

    public String getUSER()
    {
        return USER;
    }

    public void setUSER(String USER)
    {
        this.USER = USER;
    }

    public String getPW()
    {
        return PW;
    }

    public void setPW(String PW)
    {
        this.PW = PW;
    }

    public String getURL()
    {
        return URL;
    }

    public void setURL(String URL)
    {
        this.URL = URL;
    }
}

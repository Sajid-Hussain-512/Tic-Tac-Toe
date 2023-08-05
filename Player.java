public class Player
{
    private String name;
    private String avatar;

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAvatar(String avatar)
    {
        this.avatar=avatar;
    }

    public String getAvatar()
    {
        return this.avatar;
    }

    public Player(String name,String avatar)
    {
        this.setName(name);
        this.setAvatar(avatar);        
    }
}

package src;

import java.net.URL;

/**
 * Write a description of class DigitalAlbum here.
 * 
 * @author Madhu Kumar Dadi 
 * @version 6.2.2016
 */
public class DigitalAlbum
{
	public String title;
	public String annotation;
	public URL url;
	
	public DigitalAlbum()
	{
	}
	
	public DigitalAlbum(DigitalAlbum dAlbum)
	{
		this.title=dAlbum.title;
		this.annotation=dAlbum.annotation;
		this.url=dAlbum.url;
	}
}

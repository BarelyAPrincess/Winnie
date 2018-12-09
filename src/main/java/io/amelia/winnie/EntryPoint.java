package io.amelia.winnie;

public class EntryPoint
{
	public static void main( String... args ) throws Exception
	{
		WinnieServer app = new WinnieServer();

		try
		{
			app.parse(args);
		}
		catch ( StartupInterruptException e )
		{
			// Prevent exception from being printed to console
			return;
		}
	}
}

/**
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 * <p>
 * Copyright (c) 2018 Amelia Sara Greene <barelyaprincess@gmail.com>
 * Copyright (c) 2018 Penoaks Publishing LLC <development@penoaks.com>
 * <p>
 * All Rights Reserved.
 */
package io.amelia.winnie;

import io.amelia.lang.StartupInterruptException;
import io.amelia.winnie.server.WinnieServer;

public class EntryPoint
{
	public static void main( String... args ) throws Exception
	{
		WinnieServer app = new WinnieServer();

		try
		{
			app.parse( args );
		}
		catch ( StartupInterruptException e )
		{
			// Prevent exception from being printed to console
			return;
		}
	}
}

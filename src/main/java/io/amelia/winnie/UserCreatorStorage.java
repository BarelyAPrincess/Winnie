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

import java.nio.file.Path;

import io.amelia.lang.DescriptiveReason;
import io.amelia.lang.StorageException;
import io.amelia.lang.UserException;
import io.amelia.storage.backend.StorageBackend;
import io.amelia.storage.types.TableStorageType;
import io.amelia.support.NodePath;
import io.amelia.users.DefaultUsers;
import io.amelia.users.UserContext;
import io.amelia.users.UserCreator;
import io.amelia.users.UserPermissible;
import io.amelia.users.UserResult;

class UserCreatorStorage extends UserCreator
{
	private final Path storagePath;

	public UserCreatorStorage( String name, StorageBackend storageBackend, NodePath storagePath, boolean isDefault ) throws UserException.Error
	{
		super( name, isDefault );

		this.storagePath = storageBackend.getRootPath().resolve( storagePath );



		if ( !this.storagePath.supportsType( TableStorageType.class ) )
			throw new UserException.Error( null, "Only the TableStorageType is supported." );
	}

	@Override
	public UserContext create( String uuid ) throws UserException.Error
	{
		return null;
	}

	@Override
	public boolean hasUser( String uuid )
	{
		return false;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

	@Override
	public void load()
	{
		TableStorageType tableStorage = storagePath.getStorageType( TableStorageType.class );

		tableStorage.getRecords().forEach( record -> {
			UserContext userContext = new UserContext( this, record.getString( "uuid" ) );
			userContext.setValues( record );
			DefaultUsers.users.add( userContext );
		} );
	}

	@Override
	public void loginBegin( UserContext userContext, UserPermissible userPermissible, String uuid, Object... credentials )
	{

	}

	@Override
	public void loginFailed( UserContext userContext, DescriptiveReason result )
	{

	}

	@Override
	public void loginSuccess( UserContext userContext )
	{

	}

	@Override
	public void loginSuccessInit( UserContext userContext, PermissibleEntity permissibleEntity )
	{

	}

	@Override
	public void reload( UserContext userContext ) throws UserException.Error
	{

	}

	@Override
	public UserResult resolve( String uuid )
	{
		return null;
	}

	@Override
	public void save( UserContext userContext ) throws UserException.Error
	{

	}
}

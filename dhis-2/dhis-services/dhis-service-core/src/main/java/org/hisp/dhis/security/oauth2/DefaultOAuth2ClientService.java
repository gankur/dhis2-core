/*
 * Copyright (c) 2004-2022, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.hisp.dhis.security.oauth2;

import java.util.Collection;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Morten Olav Hansen <mortenoh@gmail.com>
 */
@RequiredArgsConstructor
@Service( "oAuth2ClientService" )
public class DefaultOAuth2ClientService
    implements OAuth2ClientService
{
    private final OAuth2ClientStore oAuth2ClientStore;

    // -------------------------------------------------------------------------
    // OAuth2ClientService
    // -------------------------------------------------------------------------

    @Override
    @Transactional
    public void saveOAuth2Client( OAuth2Client oAuth2Client )
    {
        oAuth2ClientStore.save( oAuth2Client );
    }

    @Override
    @Transactional
    public void updateOAuth2Client( OAuth2Client oAuth2Client )
    {
        oAuth2ClientStore.update( oAuth2Client );
    }

    @Override
    @Transactional
    public void deleteOAuth2Client( OAuth2Client oAuth2Client )
    {
        oAuth2ClientStore.delete( oAuth2Client );
    }

    @Override
    @Transactional( readOnly = true )
    public OAuth2Client getOAuth2Client( int id )
    {
        return oAuth2ClientStore.get( id );
    }

    @Override
    @Transactional( readOnly = true )
    public OAuth2Client getOAuth2Client( String uid )
    {
        return oAuth2ClientStore.getByUid( uid );
    }

    @Override
    @Transactional( readOnly = true )
    public OAuth2Client getOAuth2ClientByClientId( String cid )
    {
        return oAuth2ClientStore.getByClientId( cid );
    }

    @Override
    @Transactional( readOnly = true )
    public Collection<OAuth2Client> getOAuth2Clients()
    {
        return oAuth2ClientStore.getAll();
    }
}

package com.example.justyourkidiez.business.UseCases;

import com.example.justyourkidiez.domain.AccessToken;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}

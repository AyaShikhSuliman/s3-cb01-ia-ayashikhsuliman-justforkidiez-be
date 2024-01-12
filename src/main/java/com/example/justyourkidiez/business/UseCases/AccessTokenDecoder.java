package com.example.justyourkidiez.business.UseCases;

import com.example.justyourkidiez.domain.AccessToken;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}

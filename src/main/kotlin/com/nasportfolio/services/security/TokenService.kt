package com.nasportfolio.services.security

import com.nasportfolio.EnvConfig

interface TokenService {
    fun generateToken(
        secret: String = EnvConfig.jwtSecret,
        audience: String = DEFAULT_AUDIENCE,
        issuer: String = DEFAULT_ISSUER,
        expiresIn: Long = DEFAULT_EXPIRES_IN,
        claims: List<TokenClaim>
    ): String

    data class TokenClaim(
        val key: String,
        val value: String,
    )

    companion object {
        const val DEFAULT_AUDIENCE = "users"
        const val DEFAULT_ISSUER = "http://0.0.0.0:8080"
        const val DEFAULT_EXPIRES_IN = 30L * 24L * 60L * 60L * 1000L
    }
}
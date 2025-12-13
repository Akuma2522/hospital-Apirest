package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.LoginRequestDto;
import com.backendHospital.hospital_Apirest.dto.LoginResponseDto;


public interface AuthService {
    LoginResponseDto login(LoginRequestDto dto);
}

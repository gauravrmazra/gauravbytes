import { LoginStatus } from './login-status.enum';

export interface LoginResponse {
    token?: string;
    status?: LoginStatus;
}

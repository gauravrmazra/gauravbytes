import { LoginStatus } from './login-status.enum';

export interface User {
    token: string;
    status: LoginStatus;
    username: string;
}

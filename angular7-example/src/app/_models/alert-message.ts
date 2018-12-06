import { AlertMessageType } from './alert-message-type.enum';

export interface AlertMessage {
    type: AlertMessageType;
    message: string;
}

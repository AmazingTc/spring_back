import {Message} from "element-ui";
export default function getMessage(code,msg){
    if(code===2000){
        Message({
            type: 'success',
            message: `${msg}成功!`,
            duration:2000,
        });
    }else{
        Message({
            type: 'error',
            message: `${msg}失败！`,
            duration:2000,
        });
    }
}

#include"led.h"
        #include"delay.h"
        #include"sys.h"
        #include"usart.h"
        #include"key.h"


        int main(void){
            u8 t;
            u8 len;
            u16 times=0;
            GPIO_InitTypeDef GPIO_InitStructure;
            NVIC_PriorityGroupConfig(NVIC_PriorityGroup_2);
            LED_Init();
            KEY_Init();
            uart_init(9600);
            RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOA|RCC_APB2Periph_GPIOD,ENABLE);     //Ê¹ÄÜPA,PD¶Ë¿ÚÊ±ÖÓ
            delay_init();
            GPIO_InitStructure.GPIO_Pin=GPIO_Pin_8;                 //LED0-->PA.8 ¶Ë¿ÚÅäÖÃ
            GPIO_InitStructure.GPIO_Mode=GPIO_Mode_Out_PP;         //ÍÆÍìÊä³ö
            GPIO_InitStructure.GPIO_Speed=GPIO_Speed_50MHz;         //IO¿ÚËÙ¶ÈÎª50MHz
            GPIO_Init(GPIOA,&GPIO_InitStructure);                     //¸ù¾ÝÉè¶¨²ÎÊý³õÊ¼»¯GPIOA.8

            GPIO_InitStructure.GPIO_Pin=GPIO_Pin_2;
            GPIO_Init(GPIOD,&GPIO_InitStructure);
            GPIO_SetBits(GPIOD,GPIO_Pin_8);
            //GPIO_ResetBits(GPIOD,GPIO_Pin_2);
            while(1)
            {
            t=KEY_Scan(0);        //????
            switch(t)
            {
            case KEY0_PRES:
            printf("KEY0 Pressed\r\n");
            break;
            case KEY1_PRES:
            printf("KEY1 Pressed\r\n");
            break;
            case WKUP_PRES:
            printf("WK_UP Pressed\r\n");
            break;
    default:break;
            }

            if(USART_RX_STA&0x8000){
            if(USART_RX_BUF[0]=='l'&USART_RX_BUF[1]=='e'&USART_RX_BUF[2]=='d')
            {
            len=USART_RX_STA&0x3fff;
            if(USART_RX_BUF[3]=='1'){
            if(USART_RX_BUF[5]=='o'&USART_RX_BUF[6]=='n')
            {
            //GPIO_ResetBits(GPIOD,GPIO_Pin_2);
            LED1=0;
            }
            else
            {
            if(USART_RX_BUF[5]=='o'&USART_RX_BUF[6]=='f'&USART_RX_BUF[7]=='f')
            //GPIO_SetBits(GPIOD,GPIO_Pin_2);
            LED1=1;
            }
            }
            if(USART_RX_BUF[3]=='0'){
            if(USART_RX_BUF[5]=='o'&USART_RX_BUF[6]=='n')
            {
            //GPIO_ResetBits(GPIOD,GPIO_Pin_8);
            LED0=0;}
            else
            {
            if(USART_RX_BUF[5]=='o'&USART_RX_BUF[6]=='f'&USART_RX_BUF[7]=='f')
            //GPIO_SetBits(GPIOD,GPIO_Pin_8);
            LED0=1;}
            }


            }
            else if(USART_RX_BUF[0]!='l'&USART_RX_BUF[1]!='e'&USART_RX_BUF[2]!='d'){
            len=USART_RX_STA&0x3fff;
            printf("\r\nÄãºÃ£¬\r\n");

            for(t=0;t<len;t++)
            {
            USART1->DR=USART_RX_BUF[t];
            while((USART1->SR&0X40)==0);
            }

            }
            USART_RX_STA=0;}

            }


        }


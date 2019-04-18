package d._SerialEnc;
import Kotlin1.*;
open class Core{
    fun Bytes_To_Int(b :ByteArray) :Int{
        var v :Int= 0;
        var _v :Int= 0;
        for(i in 0..3){
            v *=256;
            _v= b[i].toInt();
            while(_v < 0){_v +=256};
            v +=_v;
        };
        return v;
    };
    fun Bytes_To_Int(b :ByteArray, a: Int) :Int{
        var v :Int= 0;
        var _v :Int= 0;
        for(i in 0..3){
            v *=256;
            _v= b[a + i].toInt();
            while(_v < 0){_v +=256};
            v +=_v;
        };
        return v;
    };
    fun Int_To_Bytes(v :Int) :Bytes= v.toBytes();
    fun Int_To_Bytes(b :ByteArray, a: Int, v :Int) :Int{
        var b :Bytes= v.toBytes();
        for(i in 0..3){ b.d!![a + i]= ((v /Math.pow(256.0, (3 -i).toDouble()).toInt()) %256).toByte(); };
        return a;
    };
};

package io;
import java.io.File;
import sys.fp as sfp;
//Note:   <io.File> can be used to open, read, write, and append to files.  
//Note:   Additional input types for this class may be added in the future.  
class File constructor(var fp :String) {
    init{ this.fp= sfp(fp); };
    operator fun plus(d :ByteArray){ File(this.fp).appendBytes(d); };
    operator fun invoke() :ByteArray= File(this.fp).readBytes();
    operator fun invoke(d :ByteArray){File(this.fp).writeBytes(d)};
    operator fun plus(d :String){ File(this.fp).appendBytes(d.toByteArray()); };
    operator fun invoke(d :String){File(this.fp).writeBytes(d.toByteArray())};
    override fun toString() :String= File(this.fp).readText().toString().replace("\r", "");
    open fun count(string :String) :Int{
        var i= 0;
        var j= 0;
        var r= true;
        while(r){
            if(i==-1){ r= false; break; };
            i= this.toString().indexOf(string, i +1);
            j++;
        };
        return j;
    };
};

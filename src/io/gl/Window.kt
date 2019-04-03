package io.gl;
import io.dl.GameKeys;
import math.ComplexDouble;
import net.Logger;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import io.dl.MouseI;
//Note:   If your AP, don't worry, I will be giving you your credit for posting your tutorials, and thankyou very much for said tutorials.  I hope you have a very nice day.  :D
class Window {
    private var Log :Logger= Logger("./SysLogs.log", "io.gl.Window");
    private var width :Int= 0;
    private var height :Int= 0;
    private var title :String= "";
    private var window :Long= 0;
    private var keys :BooleanArray= BooleanArray(GLFW.GLFW_KEY_LAST);
    private var mouseButtons :BooleanArray= BooleanArray(GLFW.GLFW_MOUSE_BUTTON_LAST);
    constructor(width :Int, height :Int, title :String){
        this.width= width;
        this.height= height;
        this.title= title;
    };
    public fun create(){
        this.width= width;
        this.height= height;
        this.title= title;
        if(!GLFW.glfwInit()) System.exit(1);
        this.window= GLFW.glfwCreateWindow(this.width, this.height, this.title, 0, 0);
        if(this.window==0L) System.exit(2);
        var videoMode= GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(this.window, (videoMode!!.width() - this.width) /2, (videoMode.height() - this.height) /2);
        GLFW.glfwShowWindow(this.window);
    };
    public fun closed() :Boolean{try{
        var oP= GLFW.glfwWindowShouldClose(this.window);
        Log.Dbg("Closed?  "+(if(oP){"Yes.  "}else{"No.  "}));
        return oP;
    }catch(Err :Exception){Log.Error("There seems to be an issue with the 'closed' method.  ");System.exit(4);return true}};
    public fun update() {
        try{for(i in 0..(GLFW.GLFW_KEY_LAST -1)) this.keys[i]= isKeyDown(i)}catch(Err :Exception){Log.Error("<io.gl.Window:update()::this.keys> is not working.  \n${Err}");System.exit(1)};
        try{for(i in 0..(GLFW.GLFW_MOUSE_BUTTON_LAST -1)) this.mouseButtons[i]= isMouseDown(i)}catch(Err :Exception){Log.Error("<io.gl.Window:update()::this.mouseButtons> is not working.  \n${Err}");System.exit(5)};
        GLFW.glfwPollEvents();
    };
    public fun getWindow() :Long= this.window;
    public fun swapBuffers() {GLFW.glfwSwapBuffers(this.window)};
    public fun isKeyDown(keyCode :Int)= GLFW.glfwGetKey(this.window, keyCode)==1;
    public fun isMouseDown(mouseButton :Int)= GLFW.glfwGetMouseButton(window, mouseButton)==1;
    public fun isKeyPressed(keyCode :Int)= this.isKeyDown(keyCode) && !this.keys[keyCode];
    public fun isKeyReleased(keyCode :Int)= this.isKeyDown(keyCode) && this.keys[keyCode];
    public fun isMousePressed(mouseButton :Int)= this.isKeyDown(mouseButton) && !this.mouseButtons[mouseButton];
    public fun isMouseReleased(mouseButton :Int)= this.isKeyDown(mouseButton) && this.mouseButtons[mouseButton];
    public fun getMouseX() :Double{    //Note:   Temporary, for dev-purposes.
        var buffer= BufferUtils.createDoubleBuffer(1);
        GLFW.glfwGetCursorPos(this.window, buffer, null);
        return buffer.get(0);
    };
    public fun getMouseY() :Double{    //Note:   Temporary, for dev-purposes.
        var buffer= BufferUtils.createDoubleBuffer(1);
        GLFW.glfwGetCursorPos(this.window, null, buffer);
        return buffer.get(0);
    };
    public fun getMouse() :MouseI= MouseI(this);
    public fun getGameKB() :Int= GameKeys(this);
};

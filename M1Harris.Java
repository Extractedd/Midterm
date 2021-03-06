//// Dymon Harris CST 112

/// Globals 

String title= " Midterm";
String help= "Click to shoot cue ball. \n 'r' key to reset, 'q to quit. \n 'w' to remove wall.";
String news= help;
String author= "Dymon Harris";

float up, right, down, left;
float center;
float mright, mleft;

float whiteX, whiteY, whiteDX, whiteDY;
float blueX, blueY, blueDX, blueDY;
float redX, redY, redDX, redDY;
float orangeX, orangeY, orangeDX, orangeDY;
float greenX, greenY, greenDX, greenDY;


/// Values
void setup() {
  size( 640, 480 );
  right= width-65;
  left=  73;
  up=  120;
  down= height-58;
  center= left + (right-left) / 2;
  mleft= 340;
  mright= 330;
  
  reset();
}


void reset() {
  whiteX= left + (right-left) / 4;
  whiteY= up + (down-up) / 2;
  whiteDX= whiteDY=0;
  
  blueX= random( center,right );  blueY= random( up, down );
  redX= random( center,right );  redY= random( up, down );
  orangeX= random( center,right );  orangeY=random( up, down );
  greenX= random( center,right );  greenY= random( up, down );
  
  blueDX= random( 1,3 );  blueDY= random( 1,3 );
  redDX= random ( 1,3 );  redDY= random( 1,3 );
  orangeDX= random ( 1,3 );  orangeDY= random( 1,3 );
  greenDX= random ( 1,3 );  greenDY= random( 1,3 );
}

//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background (150,200,250 );
  rectMode(CENTER);
  table ( left, up, right, down );
  bounce();
  collisions();
  show();
  messages();
}

//// SCENE:  draw the table with walls
void table( float left, float up, float right, float down ) {
  fill( 0, 150, 100 );
  strokeWeight(15);
  stroke( 200,200,200 );
  rect( 325,270,545,345 );
  stroke(0);
  strokeWeight(8);
  line(325,415,325,125); 
}

//// ACTION:  bounce off walls, collisions
void bounce() {
// Blue Ball Collision w. wall
   blueX += blueDX;  if ( blueX<mleft || blueX>right ) blueDX *= -1;
  blueY += blueDY;  if ( blueY<up || blueY>down ) blueDY *=  -1;
//  Red Ball Collision w. wall
  redX += redDX;  if ( redX<mleft || redX>right ) redDX *= -1;
  redY += redDY;  if ( redY<up || redY>down ) redDY *=  -1;
//  Orange Ball Collision w. wall
  orangeX += orangeDX;  if ( orangeX<mleft || orangeX>right ) orangeDX *= -1;
  orangeY += orangeDY;  if ( orangeY<up || orangeY>down ) orangeDY *=  -1;
//  Green Ball Collision w. wall
  greenX += greenDX;  if ( greenX<mleft || greenX>right ) greenDX *= -1;
  greenY += greenDY;  if ( greenY<up || greenY>down ) greenDY *=  -1;
//  White Ball Collision w. wall
  whiteX += whiteDX;  if ( whiteX<left || whiteX>right ) whiteDX *= -1;
  whiteY += whiteDY;  if ( whiteY<up || whiteY>down ) whiteDY *=  -1;
}



/// Collisions between other balls
void collisions() {
  float right,left;
  
  if  (dist( blueX, blueY, redX, redY ) < 30 ) {
    right=redDX;  redDX=blueDX;  blueDX=right;
    left=redDY;  redDY=blueDY; blueDY=left;
  }
  
  if (dist( blueX, blueY, orangeX, orangeY ) < 30 ) {
    float orangeY=orangeDX;  orangeDX=blueDX; blueDX=orangeY;
    float redY=orangeDY;  orangeDY=blueDY;  blueDY=redY;
  }
  
  if (dist( blueX, blueY, greenX, greenY ) < 30 ) {
    float greenY=greenDX;  greenDX=blueDX; blueDX=greenY;
    float redY= greenDY;  greenDY= blueDY;  blueDY=redY;
  }
  
  if  (dist( whiteX, whiteY, blueX, blueY ) < 30 ) {
    right=blueDX;  blueDX=whiteDX;  whiteDX=right;
    left=blueDY;  blueDY=whiteDY; whiteDY=left;
  }
  
   if  (dist( whiteX, whiteY, redX, redY ) < 30 ) {
    right=redDX;  redDX=whiteDX;  whiteDX=right;
    left=redDY;  redDY=whiteDY; whiteDY=left;
  }
  
   if  (dist( whiteX, whiteY, orangeX, orangeY ) < 30 ) {
    right=orangeDX;  orangeDX=whiteDX;  whiteDX=right;
    left=orangeDY;  orangeDY=whiteDY; whiteDY=left;
  }
  
   if  (dist( whiteX, whiteY, greenX, greenY ) < 30 ) {
    right=greenDX;  greenDX=whiteDX;  whiteDX=right;
    left=greenDY;  greenDY=whiteDY; whiteDY=left;
  }
  
    if  (dist( redX, redY, orangeX, orangeY ) < 30 ) {
    right=orangeDX;  orangeDX=redDX;  redDX=right;
    left=orangeDY;  orangeDY=redDY; redDY=left;
  }
  
  if  (dist( redX, redY, greenX, greenY ) < 30 ) {
    right=greenDX;  greenDX=redDX;  redDX=right;
    left=greenDY;  greenDY=redDY; redDY=left;
  }
  
  if  (dist( orangeX, orangeY, greenX, greenY ) < 30 ) {
    right=greenDX;  greenDX=orangeDX;  orangeDX=right;
    left=greenDY;  greenDY=orangeDY; orangeDY=left;
  }
}
  
 
  
 /* 
 float tmp,up,down,blueX=0;
  if (dist( whiteX, whiteY, blueX, blueY ) < 60 ) {
    up=blueDX;  blueDX=whiteDX;  whiteDX=up;
    down=blueDY;  blueDY=whiteDY;  whiteDY=down;
  }
  
  if (dist( whiteX, whiteY, redX, redY ) < 59 ) {
    blueX=redDX;  redDX=whiteDX;  whiteDX=blueX;
    blueX=redDY;  redDY=whiteDY;  whiteDY=blueX;
  }
  
  if (dist( whiteX, whiteY, orangeX, orangeY ) < 61 ) {
    tmp=orangeDX;  orangeDX=whiteDX;  whiteDX=tmp;
    tmp=orangeDY;  orangeDY=whiteDY;  whiteDY=tmp;
  }
}
*/



//// SHOW:  balls, messages
void show() {
  strokeWeight(1);
  fill( 0,0,200 );    ellipse( blueX,blueY, 30,30 );
  fill( 150,0,0 );  ellipse( redX,redY, 30,30 );
  fill( 225,100,0 );    ellipse( orangeX,orangeY, 30,30 );
  fill( 255 );    ellipse( whiteX,whiteY, 30,30 );
  fill(0,150,0);  ellipse( greenX,greenY, 30,30);

}
void messages() {
  fill(0);
  text( title, width/3, 20 );
  text( news, width/3, 42 );
  text( author, 10, height-11 );
}


//// HANDLERS:  keys, click
void keyPressed() {
  if (key == 'r') {
    reset();
  }
  if (key == '+') { blueDX *=2; blueDY *=2; }
  if (key == '-') { blueDX /=2; blueDY /=2; }
  
  if (key == 'w') { mleft = left; }
  if (key == 'q') {
    exit();
  }
}

void mousePressed() {
  //// hit the cue ball -- distance = force
  float force=  dist( mouseX,mouseY, whiteX,whiteY ) / 20;
  strokeWeight( force );
  line( mouseX,mouseY, whiteX,whiteY );
  strokeWeight(1);
  //
  whiteDX=  (whiteX-mouseX) / 28.9;
  whiteDY=  (whiteY-mouseY) / 31.2;
}


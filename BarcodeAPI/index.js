const express = require('express')
const app = express();


// will be using camecase for key 
var barcodes = [{ "id"      : "8902519009845",
                  "name"    : "Classmate NoteBook" ,
                  "price"   : 75 ,
                  "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61WeQOf7d6L._SX466_.jpg" ,
                  "desc"    : " Classmate Long Notebook 29.7cm*21cm ...",
                  "found"   : true
                },
                { "id"      : "8901248744034",
                  "name"    : "ChawayanPlus" ,
                  "price"   : 280 ,
                  "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/41kliKnwFeL.jpg" ,
                  "desc"    : "Zandu Chawan Plus with memory boosters ...",
                  "found"   : true
                },
                { "id"      : "748927023848",
                  "name"    : "Creatine Powder" ,
                  "price"   : 1269 ,
                  "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/71rwgU7cR5L._SX466_.jpg" ,
                  "desc"    : " Creatine Powder monohydrate  ...",
                  "found"   : true
                },
                { "id"      : "8901719112393",
                  "name"    : "Parle-G" ,
                  "price"   : 5 ,
                  "imageUrl": "https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/PArle.png?b5k1V9Bk9kru.WXApRa6TRnt9EVm3a_9",
                  "desc"    : " Parle-G , G meanse Genius ...",
                  "found"   : true
                }];            
    
// for(var i = 0;i<4;i++){
//     if(barcodes[i].price == "75.00")
//       console.log(barcodes[i]);
// }

app.get('/',(req,res)=>{
        res.send("This is the home Page <br> <br>  visit  to access barcode api =>  <H1> /api/barcodes/:id </H1> ");
});


app.get('/api/barcodes',(req,res)=>{
    res.send(barcodes);
});

app.get('/api/barcodes/:id',(req,res)=>{
   
    var barcode = req.params.id; 
    
    var found = null;
    for(var i = 0;i<4;i++){
        if(barcodes[i].id == barcode){
            res.send(barcodes[i]);
            return ;
        }
    }

    return res.send({ "found " : false});
 
});

const port = process.env.PORT || 1337;
app.listen(port , ()=>{
    console.log("Server running at http://localhost:%d", port);
});

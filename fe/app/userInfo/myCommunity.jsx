import React, {Component}from 'react'
import ReactDOM from 'react-dom';
import ItemCard4 from '../items/itemCard4.jsx';

import jQuery from "jquery";
window.$ = window.jQuery = jQuery;

import './Modal.css';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class MyCommunity extends Component {
    
    constructor(props){
        super(props);
        this.state = { community: [] , pageNum: 1 , count: 0, modal : false , programId : 0 , file : '', previewURL:'',UD:0 ,
                       item:[] };
     
        // document.getElementById("register_form").addEventListener("submit",this.result_submit.bind(this));

    }
 
    async componentDidMount(){
         let {data: community} = await axios.get('/userInfo/myCommunity/axios')
         this.state.programId = community.pop()

        this.setState({community})
        
    }
    handleOpenModal(){
        this.setState({modal:true});
      };
    handleOpenModal2(c){
        console.log(c);


        this.setState({UD:1})
        this.setState({item:c})
        this.setState({modal:true});
      };
      handleCloseModal(){
        this.setState({previewURL:""})
        this.setState({UD:0})
        this.setState({modal:false});
      };  

    checkImage(event){

        event.preventDefault();
        let reader = new FileReader();
        let file = event.target.files[0];

        reader.onloadend = () => {
          this.setState({
            file : file,
            previewURL : reader.result
          })
        }
        reader.readAsDataURL(file);
      }

    render() {
        let profile_preview = null;
        if(this.state.file !== ''){
          profile_preview = <img  className='profile_preview' src={this.state.previewURL}></img>
        }

        return(
                <div id="tablebox">
                    <h3>후보자 and 팬클럽 목록</h3>
              {/* <Pagination count={this.state.count} page={this.state.pageNum} onChange={this.pagenation.bind(this)}> </Pagination> */}

                <div className="community_item">
                    
                    {this.state.community.map((c,index)=> { 
                      
                      return(
                    
                        <div key={c.name+index} className="community_index_item">

                        <div onClick={this.handleOpenModal2.bind(this,c)}>
                         <ItemCard4 key={c.img} img={c.img} name={c.name} />
                        </div>
                 
                        </div>)
                     })}
             
                </div>
                       <button onClick={this.handleOpenModal.bind(this)}>추가</button>

                  {this.state.modal && (
                   <div className="MyModal"> 
                      <div className="content">

                      {this.state.UD == 0 && <h3>후보 추가</h3>}{this.state.UD != 0 && <h3>후보 수정</h3>}
                
                    <table className="register_table">
                      <tbody>
                         <tr>
                            {this.state.UD == 0 && <td><input type="text" name="name" placeholder="이름" required/></td>}
                            {this.state.UD != 0 && <td><input type="text" name="name" placeholder="이름" defaultValue={this.state.item.name} required/></td>}
                         </tr>

                        <tr>
                            <td>{profile_preview}</td>
                        </tr>

                        <tr>
                            <td><input type="file" name="img2" accept="image/*" onChange={this.checkImage.bind(this)}/></td> 
                       </tr> 
                         
                       </tbody>
                    </table>   
                            {this.state.UD != 0 && <input type="hidden" name="id" value={this.state.item.id}></input>}
                            
                            <input type="hidden" name="pid" value={this.state.programId}></input>
                            <input type="hidden" name="img" value={this.state.item.img}></input>
 
                      {this.state.UD == 0 &&  <button formAction="/userInfo/insertPopular">등록</button>}
                      {this.state.UD != 0 &&  <button formAction="/userInfo/updatePopular">수정</button>}
                      {this.state.UD != 0 &&  <button formAction="/userInfo/deletePopular">삭제</button>}
                      <button type="button" onClick={this.handleCloseModal.bind(this)}>닫기</button>
                     
                      </div>
                  </div> )}{""} 



        </div>
        )
     
    }
}

ReactDOM.render(<MyCommunity/>,document.getElementById('my'));

import React, {Component}from 'react'
import ReactDOM from 'react-dom';
import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import Pagination from '@material-ui/lab/Pagination';

import ItemCard4 from '../items/itemCard4.jsx';

import jQuery from "jquery";
window.$ = window.jQuery = jQuery;

import './Modal.css';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class MyCommunity extends Component {
    
    constructor(props){
        super(props);
        this.state = { community: [] , pageNum: 1 , count: 0, modal : false , programId : 0 , file : '', previewURL:''};
     
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
      handleCloseModal(){
        
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
                    
                    <Index  community={this.state.community}/>    
             
                </div>
                           <button onClick={this.handleOpenModal.bind(this)}>추가</button>
                           {this.state.modal && (
                   <div className="MyModal"> 
                      <div className="content">
                        <h3>후보 추가</h3>
                        
                <table className="register_table">
                    <tbody>
                    <tr>
                    <td><input type="text" name="name" placeholder="이름" required/></td>
                    </tr>

                    <tr>
                    <td>{profile_preview}</td>
                    </tr>

                    <tr>
                     <td><input type="file" name="img2" accept="image/*" onChange={this.checkImage.bind(this)} required/></td> 
                    </tr> 
                         
                    </tbody>
                </table>
                <input type="hidden" name="pid" value={this.state.programId}></input>
                <input type="hidden" name="img" value="default"></input>
                <button type="submit">등록</button>

                        <button onClick={this.handleCloseModal.bind(this)}>닫기</button>
                      </div>
                  </div> )}{""} 



        </div>
        )
     
    }
}
class Index extends Component{
    constructor(props){
        super(props);
       this.props.community
       this.state = { modal : false, file : '', previewURL:'' , item:[]};
     // document.getElementById("register_form").addEventListener("submit",this.result_submit.bind(this));
      
    }
    handleOpenModal(c){
      console.log(c)
      this.setState({modal:true});
      this.setState({item:c})
      console.log(this.state.previewURL)

    };
    handleCloseModal(c){
      document.getElementById("name").value = c.name;
      this.setState({modal:false});
      this.componentDidMount()
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
    async componentDidMount(){
     
     
  }
    render(){
        
         //console.log(this.props.community)
         let profile_preview = null;
         if(this.state.file !== ''){
           profile_preview = <img  className='profile_preview' src={this.state.previewURL}></img>
         }

         return this.props.community.map((c,index)=>{
               return (
                    <div key={c.name+index} className="community_index_item">

                        <div onClick={this.handleOpenModal.bind(this,c)}>
                       <ItemCard4 key={c.img} img={c.img} name={c.name} />
                    
                        </div>
                      {this.state.modal &&                                              
                          <div className="MyModal"> 
                             <div className="content">
                                <h3>후보 수정</h3>
                                
                            <table>
                            <tbody>
                            <tr>
                            <td><input type="text" id="name" name="name" value={this.state.item.name} required/></td>
                            </tr>

                            <tr>
                            <td>{profile_preview}</td>
                            </tr>

                            <tr>
                            <td><input type="file" name="img2"accept="image/*" onChange={this.checkImage.bind(this)} required/></td> 
                            </tr> 
                                
                            </tbody>
                            </table>
                        <input type="hidden" name="pid" value={this.state.item.p_id}></input>
                        <input type="hidden" name="img" value="default"></input>
                        <button type="submit">등록</button>

                                <button onClick={this.handleCloseModal.bind(this)}>닫기</button>
                              </div>
                         </div> }{""} 
                    </div>
                    
                )
            }
        )
    }
        
    
}

ReactDOM.render(<MyCommunity/>,document.getElementById('my'));

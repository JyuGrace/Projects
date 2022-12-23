//import { React, useEffect, useState} from 'react'
import { Button, Container, Row, Col, Nav } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import styled from '@emotion/styled'
//import submitHandler from '../validations/UserLoginValidation.jsx'

import '../styles/login.css'
import login from '../imgs/login.png'
import logo2 from '../imgs/logo2.png'

import React, { useState, useRef } from "react";
import { useNavigate } from 'react-router-dom';
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import AuthService from "../services/auth.service";

const Titulo = styled.h2`
  color: #054789;
  font-weight: bold;
`
const Subtitulo = styled.h3`
  color: #db266b;
  font-weight: bold;
`
const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const Login = () => {

  let navigate = useNavigate();

  const form = useRef();
  const checkBtn = useRef();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState("");

  const onChangeUsername = (e) => {
    const username = e.target.value;
    setUsername(username);
  };

  const onChangePassword = (e) => {
    const password = e.target.value;
    setPassword(password);
  };

  const handleLogin = (e) => {
    e.preventDefault();

    setMessage("");
    setLoading(true);

    form.current.validateAll();

    if (checkBtn.current.context._errors.length === 0) {
      AuthService.login(username, password).then(
        () => {
          navigate("/order");
          window.location.reload();
        },
        (error) => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          setLoading(false);
          setMessage(resMessage);
        }
      );
    } else {
      setLoading(false);
    }
  };


  return (
    <>
      <div className='pagina'>
        <Container>
          <Row className="justify-content-md-center">
            {/* --------- Fila con Barra Roja --------- */}
            <p></p><p></p>
            <Row><div className='empy-bar'></div></Row>
            
            {/* --------- Columna con Logo, Login y Register --------- */}
            <Col>
              {/* --------- Fila General con Logo, Login y Register --------- */}
              <Row>
                <p></p>
                {/* --------- Columna con Logo (y subtitulo) --------- */}
                <Col className='alineacion'>
                  <img src={logo2} style ={{"width": "60%"}} className='logo-img'/>
                  <p></p><p></p>
                  <Subtitulo>Empresa de Gestion de Paquetes</Subtitulo>
                </Col>
                
                {/* --------- Columna con Login y Register --------- */}
                <Col className='alineacion'>

                  {/* --------- Fila con Login --------- */}
                  <Row>
                    <Titulo>Bienvenido</Titulo>
                      
                    <Container className='justify-content-between'>
                      <Form className='row' onSubmit={handleLogin} ref={form} method="POST">
                        <div className="mb-3" >
                          <label>Usuario</label>
                          <input type="text" name="username" value={username} onChange={onChangeUsername} validations={[required]} id="exampleInputUsuario1" minLength="5" required/>
                        </div>

                        <div className="mb-3" >
                          <label>Contraseña</label>
                          <input type="password" name="password" value={password} onChange={onChangePassword} validations={[required]} id="exampleInputPassword1" minLength="5" required/>
                        </div>

                        <Button variant="primary" type="submit" >
                          Login
                        </Button>
                        {message && (
                          <div className="form-group">
                            <div className="alert alert-danger" role="alert">
                              {message}
                            </div>
                          </div>
                        )}
                        <CheckButton style={{ display: "none" }} ref={checkBtn} />
                      </Form>
                    </Container>
                  </Row>

                  {/* --------- Fila con Register --------- */}
                  <Row>
                    <p></p><p></p>
                    <div><Nav.Link as={Link} to="/register" className='text-light'><Subtitulo>Registrarse</Subtitulo></Nav.Link></div>
                  </Row>
                </Col>
              </Row>
            </Col>

            {/* --------- Columna con Imagen Grande --------- */}
            <Col>
              <img src={login} style ={{"width": "85%"}} className='imgStyle'/>
            </Col>
            {/* --------- Fila con Barra Azul --------- */}
            <Row><div className="barra-gigante"></div></Row>

          </Row>
        </Container>
      </div>
    </>
  )
}

export default Login;
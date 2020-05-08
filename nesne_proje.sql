--
-- PostgreSQL database dump
--

-- Dumped from database version 12.0
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: InternetKullanicilari; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."InternetKullanicilari" (
    "KullaniciAdi" character varying(100) NOT NULL,
    "Sifre" character varying(100) NOT NULL,
    "KullaniciID" integer NOT NULL
);


ALTER TABLE public."InternetKullanicilari" OWNER TO postgres;

--
-- Name: InternetKullanicilari_KullaniciID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."InternetKullanicilari_KullaniciID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."InternetKullanicilari_KullaniciID_seq" OWNER TO postgres;

--
-- Name: InternetKullanicilari_KullaniciID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."InternetKullanicilari_KullaniciID_seq" OWNED BY public."InternetKullanicilari"."KullaniciID";


--
-- Name: InternetKullanicilari KullaniciID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."InternetKullanicilari" ALTER COLUMN "KullaniciID" SET DEFAULT nextval('public."InternetKullanicilari_KullaniciID_seq"'::regclass);


--
-- Data for Name: InternetKullanicilari; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."InternetKullanicilari" VALUES ('kadircelik34', 'kadir123', 2);
INSERT INTO public."InternetKullanicilari" VALUES ('duhanuzun18', '1234567', 1);
INSERT INTO public."InternetKullanicilari" VALUES ('huseyinhira58', 'qazwsx123', 5);


--
-- Name: InternetKullanicilari_KullaniciID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."InternetKullanicilari_KullaniciID_seq"', 6, true);


--
-- Name: InternetKullanicilari InternetKullanicilari_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."InternetKullanicilari"
    ADD CONSTRAINT "InternetKullanicilari_pkey" PRIMARY KEY ("KullaniciID");


--
-- Name: InternetKullanicilari unique_InternetKullanicilari_KullaniciID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."InternetKullanicilari"
    ADD CONSTRAINT "unique_InternetKullanicilari_KullaniciID" UNIQUE ("KullaniciID");


--
-- Name: InternetKullanicilari unique_InternetKullanicilari_Sifre; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."InternetKullanicilari"
    ADD CONSTRAINT "unique_InternetKullanicilari_Sifre" UNIQUE ("Sifre");


--
-- PostgreSQL database dump complete
--


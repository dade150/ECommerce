PGDMP      (            
    {         	   ECommerce    16.0    16.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16828 	   ECommerce    DATABASE     ~   CREATE DATABASE "ECommerce" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Italian_Italy.1252';
    DROP DATABASE "ECommerce";
                postgres    false            �            1259    16830    Prodotto    TABLE     �   CREATE TABLE public."Prodotto" (
    id integer NOT NULL,
    nome character varying(20),
    descrizione character varying,
    quantita integer,
    prezzo double precision
);
    DROP TABLE public."Prodotto";
       public         heap    postgres    false            �            1259    16829    Prodotto_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Prodotto_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public."Prodotto_id_seq";
       public          postgres    false    216            �           0    0    Prodotto_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public."Prodotto_id_seq" OWNED BY public."Prodotto".id;
          public          postgres    false    215            P           2604    16833    Prodotto id    DEFAULT     n   ALTER TABLE ONLY public."Prodotto" ALTER COLUMN id SET DEFAULT nextval('public."Prodotto_id_seq"'::regclass);
 <   ALTER TABLE public."Prodotto" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216            �          0    16830    Prodotto 
   TABLE DATA                 public          postgres    false    216   �
       �           0    0    Prodotto_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."Prodotto_id_seq"', 6, true);
          public          postgres    false    215            R           2606    16837    Prodotto Prodotto_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Prodotto"
    ADD CONSTRAINT "Prodotto_pkey" PRIMARY KEY (id);
 D   ALTER TABLE ONLY public."Prodotto" DROP CONSTRAINT "Prodotto_pkey";
       public            postgres    false    216            �   �   x��ҽ
�0�Oq���R�Z'��T�k?� i.�t��{�">�2��~���9��(O;��US�N��k��'Q���F%P�G�#6r��h<yL�:�u�e�=o����z(�5ݸ!�j}��ȫ,��UP���D�hz#D��s6sn.L���Y֚{L���V>���)Zet6kj����{O>d<���     